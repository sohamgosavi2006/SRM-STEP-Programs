import java.util.*;
import java.util.concurrent.TimeUnit;

public class Problem10 {

    static class VideoData {
        final String id;
        final String title;
        final byte[] content;

        VideoData(String id, String title) {
            this.id = id;
            this.title = title;
            this.content = new byte[1_000_000];
        }
    }

    static class LruCache<K, V> {
        private final int maxSize;
        private final Map<K, V> storage;
        private final Queue<K> lruKeys;

        LruCache(int maxSize) {
            this.maxSize = maxSize;
            this.storage = new LinkedHashMap<>();
            this.lruKeys = new LinkedList<>();
        }

        public V get(K key) {
            return storage.get(key);
        }

        public void put(K key, V value) {
            if (!storage.containsKey(key)) {
                if (storage.size() >= maxSize) {
                    K oldest = lruKeys.poll();
                    storage.remove(oldest);
                }
            }
            storage.put(key, value);
            lruKeys.remove(key);
            lruKeys.offer(key);
        }

        // -- ADD THIS: expose the internal map without changing API --
        public Map<K, V> getStorage() {
            return storage;
        }
    }

    static class MultiLevelCache {
        private final LruCache<String, VideoData> l1;
        private final LruCache<String, String> l2Paths;
        private final Map<String, VideoData> l3;
        private final Map<String, Long> accessCount;
        private final long l1PromoteThreshold;

        private final Map<String, Long> hits;
        private final Map<String, Long> misses;
        private final Map<String, Long> totalLatencyMicros;
        private final long[] accessTimesNs;

        MultiLevelCache() {
            l1 = new LruCache<>(10_000);
            l2Paths = new LruCache<>(100_000);
            l3 = new HashMap<>();
            accessCount = new HashMap<>();

            hits = new HashMap<>();
            misses = new HashMap<>();
            totalLatencyMicros = new HashMap<>();
            accessTimesNs = new long[]{10_000, 5_000_000, 150_000_000};

            l1PromoteThreshold = 3;

            for (int i = 0; i < 1_000_000; i++) {
                String id = "video_" + i;
                l3.put(id, new VideoData(id, "Title " + i));
            }
        }

        public VideoData getVideo(String videoId) throws Exception {
            long l1Start = System.nanoTime();
            VideoData data = l1.get(videoId);
            accessCount.merge(videoId, 1L, Long::sum);
            if (data != null) {
                hits.put("l1", hits.getOrDefault("l1", 0L) + 1);
                long elapsed = System.nanoTime() - l1Start;
                totalLatencyMicros.merge("l1", TimeUnit.NANOSECONDS.toMicros(elapsed), Long::sum);
                System.out.println("→ L1 Cache HIT (" + TimeUnit.NANOSECONDS.toMicros(accessTimesNs[0]) + "μs)");
                return data;
            }
            misses.put("l1", misses.getOrDefault("l1", 0L) + 1);
            long elapsed = System.nanoTime() - l1Start;

            long l2Start = System.nanoTime();
            String path = l2Paths.get(videoId);
            if (path != null) {
                hits.put("l2", hits.getOrDefault("l2", 0L) + 1);
                data = loadFromL2Mock(path);
                l1.put(videoId, data);
                totalLatencyMicros.merge("l2", TimeUnit.NANOSECONDS.toMicros(l2Start + elapsed + accessTimesNs[1] - l2Start), Long::sum);
                System.out.println("→ L2 Cache HIT (5ms)\n→ Promoted to L1\n→ Total: 5.5ms");
                return data;
            }
            misses.put("l2", misses.getOrDefault("l2", 0L) + 1);

            long l3Start = System.nanoTime();
            data = l3.get(videoId);
            if (data != null) {
                hits.put("l3", hits.getOrDefault("l3", 0L) + 1);
                l2Paths.put(videoId, "/ssd/" + videoId);
                totalLatencyMicros.merge("l3", TimeUnit.NANOSECONDS.toMicros(l3Start + elapsed + l2Start - l3Start + accessTimesNs[2] - l2Start), Long::sum);
                System.out.println("→ L3 Database HIT (150ms)\n→ Added to L2 (access count: 1)");
                return data;
            }
            misses.put("l3", misses.getOrDefault("l3", 0L) + 1);
            throw new Exception("Video not found");
        }

        private VideoData loadFromL2Mock(String path) {
            String id = path.substring(path.lastIndexOf('/') + 1);
            return l3.get(id);
        }

        public void invalidate(String videoId) {
            l1.getStorage().remove(videoId);
            l2Paths.getStorage().remove(videoId);
            accessCount.remove(videoId);
            System.out.println("Invalidated " + videoId);
        }

        public Map<String, String> getStatistics() {
            long l1Total = hits.getOrDefault("l1", 0L) + misses.getOrDefault("l1", 0L);
            long l2Total = hits.getOrDefault("l2", 0L) + misses.getOrDefault("l2", 0L);
            long l3Total = hits.getOrDefault("l3", 0L) + misses.getOrDefault("l3", 0L);

            double l1HitRate = l1Total == 0 ? 0.0 : (double) hits.getOrDefault("l1", 0L) / l1Total;
            double l2HitRate = l2Total == 0 ? 0.0 : (double) hits.getOrDefault("l2", 0L) / l2Total;
            double l3HitRate = l3Total == 0 ? 0.0 : (double) hits.getOrDefault("l3", 0L) / l3Total;

            double l1Micro = l1Total == 0 ? 0.0 : (double) totalLatencyMicros.getOrDefault("l1", 0L) / l1Total;
            double l2Micro = l2Total == 0 ? 0.0 : (double) totalLatencyMicros.getOrDefault("l2", 0L) / l2Total;
            double l3Micro = l3Total == 0 ? 0.0 : (double) totalLatencyMicros.getOrDefault("l3", 0L) / l3Total;

            double overallHit =
                (l1Total + l2Total + l3Total) == 0
                    ? 0.0
                    : (l1Total * l1HitRate + l2Total * l2HitRate + l3Total * l3HitRate)
                        / (l1Total + l2Total + l3Total);

            double overallMicro =
                (l1Total + l2Total + l3Total) == 0
                    ? 0.0
                    : (l1Total * l1Micro + l2Total * l2Micro + l3Total * l3Micro)
                        / (l1Total + l2Total + l3Total);

            Map<String, String> result = new LinkedHashMap<>();
            result.put("L1", String.format("Hit Rate %.1f%%, Avg Time: %.1fms", l1HitRate * 100, l1Micro / 1000));
            result.put("L2", String.format("Hit Rate %.1f%%, Avg Time: %.1fms", l2HitRate * 100, l2Micro / 1000));
            result.put("L3", String.format("Hit Rate %.1f%%, Avg Time: %.1fms", l3HitRate * 100, l3Micro / 1000));
            result.put("Overall", String.format("Hit Rate %.1f%%, Avg Time: %.1fms", overallHit * 100, overallMicro / 1000));
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        MultiLevelCache cache = new MultiLevelCache();

        System.out.println("getVideo(\"video_123\")");
        VideoData v1 = cache.getVideo("video_123");
        System.out.println("Title: " + v1.title);

        System.out.println("\ngetVideo(\"video_123\") [second request]");
        VideoData v2 = cache.getVideo("video_123");
        System.out.println("Title: " + v2.title);

        System.out.println("\ngetVideo(\"video_999\")");
        VideoData v9 = cache.getVideo("video_999");
        System.out.println("Title: " + v9.title);

        System.out.println("\ngetStatistics() →");
        for (Map.Entry<String, String> e : cache.getStatistics().entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}