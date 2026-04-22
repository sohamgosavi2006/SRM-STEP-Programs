import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Problem3 {

    static class DNSEntry {
        final String ipAddress;
        final long createTime;
        final long expiryTime;

        DNSEntry(String ip, long ttlSeconds) {
            ipAddress = ip;
            createTime = System.currentTimeMillis();
            expiryTime = createTime + ttlSeconds * 1000;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }
    }

    private final int maxCapacity;
    private final Map<String, DNSEntry> cache;
    private final Queue<String> lruKeys;
    private int hits;
    private int misses;
    private long totalLatencyMicros;

    public Problem3(int capacity) {
        maxCapacity = capacity;
        cache = new ConcurrentHashMap<>();
        lruKeys = new LinkedList<>();
        hits = 0;
        misses = 0;
        totalLatencyMicros = 0;

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::cleanExpired, 1, 1, TimeUnit.SECONDS);
    }

    private String simulateQuery(String domain) {
        if ("google.com".equals(domain)) {
            long now = System.currentTimeMillis() % 10;
            return now < 5 ? "172.217.14.206" : "172.217.14.207";
        }
        return "127.0.0.1";
    }

    private long fakeLatencyMicros() {
        return 10 + (long) (Math.random() * 50);
    }

    public String resolve(String domain) {
        long start = System.nanoTime();
        DNSEntry entry = cache.get(domain);

        if (entry != null && !entry.isExpired()) {
            hits++;
            String ip = entry.ipAddress;
            long elapsed = System.nanoTime() - start;
            totalLatencyMicros += TimeUnit.NANOSECONDS.toMicros(elapsed);
            touch(domain);
            return "Cache HIT → " + ip;
        }

        misses++;
        String ip = simulateQuery(domain);
        long elapsed = System.nanoTime() - start;
        totalLatencyMicros += TimeUnit.NANOSECONDS.toMicros(elapsed);

        DNSEntry newEntry = new DNSEntry(ip, 300);

        synchronized (lruKeys) {
            if (cache.size() >= maxCapacity) {
                String oldest = lruKeys.poll();
                cache.remove(oldest);
            }
            cache.put(domain, newEntry);
            lruKeys.remove(domain);
            lruKeys.offer(domain);
        }

        return "Cache MISS → " + ip;
    }

    private void touch(String domain) {
        synchronized (lruKeys) {
            if (lruKeys.remove(domain)) {
                lruKeys.offer(domain);
            }
        }
    }

    private void cleanExpired() {
        cache.entrySet().removeIf(e -> e.getValue().isExpired());
        synchronized (lruKeys) {
            lruKeys.removeIf(k -> cache.get(k) == null);
        }
    }

    public String getCacheStats() {
        int total = hits + misses;
        double hitRate = total == 0 ? 0 : (double) hits / total;
        double avgMicros = total == 0 ? 0 : (double) totalLatencyMicros / total;
        return String.format("Hit Rate: %.1f%%, Avg Lookup Time: %.1fμs", hitRate * 100, avgMicros);
    }

    public static void main(String[] args) throws InterruptedException {
        Problem3 dns = new Problem3(100);

        System.out.println("resolve(\"google.com\") → " + dns.resolve("google.com") + " (TTL: 300s)");
        Thread.sleep(100);
        System.out.println("resolve(\"google.com\") → " + dns.resolve("google.com") + " (retrieved in 0.2ms)");

        Thread.sleep(301_000);

        System.out.println("resolve(\"google.com\") → " + dns.resolve("google.com") + " (TTL 300s)");

        System.out.println("getCacheStats() → " + dns.getCacheStats());
    }
}