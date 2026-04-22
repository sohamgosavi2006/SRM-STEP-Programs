import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Problem5 {

    static class Event {
        final String url;
        final String userId;
        final String source;

        Event(String url, String userId, String source) {
            this.url = url;
            this.userId = userId;
            this.source = source;
        }
    }

    static class AnalyticsEngine {

        private final Map<String, AtomicLong> pageViews;
        private final Map<String, Set<String>> uniqueVisitors;
        private final Map<String, AtomicLong> sourceCounts;
        private volatile long lastDashboardTime;

        public AnalyticsEngine() {
            pageViews = new ConcurrentHashMap<>();
            uniqueVisitors = new ConcurrentHashMap<>();
            sourceCounts = new ConcurrentHashMap<>();
            lastDashboardTime = System.currentTimeMillis();
        }

        public void processEvent(Event e) {
            pageViews.computeIfAbsent(e.url, k -> new AtomicLong()).incrementAndGet();
            uniqueVisitors.computeIfAbsent(e.url, k -> Collections.synchronizedSet(new HashSet<>()))
                          .add(e.userId);
            sourceCounts.computeIfAbsent(e.source, k -> new AtomicLong()).incrementAndGet();
        }

        public List<String> getTopPages(int k) {
            List<Map.Entry<String, AtomicLong>> list = new ArrayList<>(pageViews.entrySet());
            list.sort((a, b) -> Long.compare(b.getValue().get(), a.getValue().get()));
            List<String> result = new ArrayList<>();
            int rank = 1;
            for (Map.Entry<String, AtomicLong> e : list) {
                if (rank > k) break;
                long views = e.getValue().get();
                int uniques = uniqueVisitors.getOrDefault(e.getKey(), Collections.emptySet()).size();
                result.add(rank + ". " + e.getKey() + " - " + views + " views (" + uniques + " unique)");
                rank++;
            }
            return result;
        }

        public Map<String, Double> getTrafficSourcePercentages() {
            Map<String, Double> result = new LinkedHashMap<>();
            long total = 0;
            for (AtomicLong v : sourceCounts.values()) {
                total += v.get();
            }
            if (total == 0) return result;
            List<Map.Entry<String, AtomicLong>> list = new ArrayList<>(sourceCounts.entrySet());
            list.sort((a, b) -> Long.compare(b.getValue().get(), a.getValue().get()));
            for (Map.Entry<String, AtomicLong> e : list) {
                double pct = (e.getValue().get() * 100.0) / total;
                result.put(e.getKey(), pct);
            }
            return result;
        }

        public void updateDashboardIfNeeded() {
            long now = System.currentTimeMillis();
            if (now - lastDashboardTime >= 5000) {
                lastDashboardTime = now;
                printDashboard();
            }
        }

        public void printDashboard() {
            System.out.println("===== Real-Time Dashboard =====");
            System.out.println("Top Pages:");
            for (String line : getTopPages(10)) {
                System.out.println(line);
            }
            System.out.println();
            System.out.println("Traffic Sources:");
            Map<String, Double> src = getTrafficSourcePercentages();
            for (Map.Entry<String, Double> e : src.entrySet()) {
                System.out.printf("%s: %.1f%%%n", e.getKey(), e.getValue());
            }
            System.out.println("================================");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AnalyticsEngine engine = new AnalyticsEngine();

        engine.processEvent(new Event("/article/breaking-news", "user_123", "google"));
        engine.processEvent(new Event("/article/breaking-news", "user_456", "facebook"));
        engine.processEvent(new Event("/sports/championship", "user_123", "direct"));
        engine.processEvent(new Event("/sports/championship", "user_789", "google"));

        Random rand = new Random();
        String[] urls = {
            "/article/breaking-news",
            "/sports/championship",
            "/tech/new-gadget",
            "/economy/market-update"
        };
        String[] users = {"user_111", "user_222", "user_333", "user_444", "user_555"};
        String[] sources = {"google", "facebook", "direct", "other"};

        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 12_000) {
            String url = urls[rand.nextInt(urls.length)];
            String user = users[rand.nextInt(users.length)];
            String source = sources[rand.nextInt(sources.length)];
            engine.processEvent(new Event(url, user, source));
            engine.updateDashboardIfNeeded();
            Thread.sleep(50);
        }

        engine.printDashboard();
    }
}