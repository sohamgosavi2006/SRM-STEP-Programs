import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Problem6 {

    static class TokenBucket {
        final long maxTokens;
        final long fillSeconds;
        AtomicLong tokens;
        AtomicLong lastRefillTime;

        TokenBucket(long maxTokens, long fillSeconds) {
            this.maxTokens = maxTokens;
            this.fillSeconds = fillSeconds;
            this.tokens = new AtomicLong(maxTokens);
            this.lastRefillTime = new AtomicLong(System.currentTimeMillis());
        }

        void refill() {
            long now = System.currentTimeMillis();
            long elapsed = now - lastRefillTime.get();
            long periods = elapsed / (fillSeconds * 1000);
            if (periods > 0) {
                long newTokens = Math.min(periods * maxTokens, maxTokens);
                long current = tokens.get();
                long updated = Math.min(current + newTokens, maxTokens);
                if (tokens.compareAndSet(current, updated)) {
                    lastRefillTime.getAndUpdate(prev -> {
                        long newTime = prev + periods * fillSeconds * 1000;
                        return newTime > now ? now : newTime;
                    });
                }
            }
        }

        boolean consume() {
            refill();
            long current = tokens.get();
            if (current <= 0) {
                return false;
            }
            return tokens.compareAndSet(current, current - 1);
        }

        long getUsed() {
            return maxTokens - tokens.get();
        }

        long getRemaining() {
            return tokens.get();
        }

        long getNextReset() {
            long now = System.currentTimeMillis();
            long last = lastRefillTime.get();
            long elapsed = now - last;
            long periods = elapsed / (fillSeconds * 1000);
            long next = last + (periods + 1) * fillSeconds * 1000;
            return next;
        }
    }

    static class RateLimiter {
        final long maxRequestsPerHour;
        final Map<String, TokenBucket> clients;

        public RateLimiter(long maxPerHour) {
            maxRequestsPerHour = maxPerHour;
            clients = new ConcurrentHashMap<>();
        }

        public String checkRateLimit(String clientId) {
            TokenBucket bucket = clients.computeIfAbsent(clientId, k -> new TokenBucket(maxRequestsPerHour, 3600));
            if (bucket.consume()) {
                long remaining = bucket.getRemaining();
                return "Allowed (" + remaining + " requests remaining)";
            }
            long reset = (bucket.getNextReset() - System.currentTimeMillis()) / 1000;
            return "Denied (0 requests remaining, retry after " + reset + "s)";
        }

        public Map<String, Object> getRateLimitStatus(String clientId) {
            Map<String, Object> result = new LinkedHashMap<>();
            TokenBucket bucket = clients.get(clientId);
            if (bucket == null) {
                result.put("used", 0L);
                result.put("limit", maxRequestsPerHour);
                result.put("reset", System.currentTimeMillis() / 1000 + 3600);
                return result;
            }
            result.put("used", bucket.getUsed());
            result.put("limit", maxRequestsPerHour);
            result.put("reset", bucket.getNextReset() / 1000);
            return result;
        }
    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter(1000);

        System.out.println("checkRateLimit(clientId=\"abc123\") → " + limiter.checkRateLimit("abc123"));
        System.out.println("checkRateLimit(clientId=\"abc123\") → " + limiter.checkRateLimit("abc123"));

        for (int i = 0; i < 1000; i++) {
            limiter.checkRateLimit("abc123");
        }

        System.out.println("checkRateLimit(clientId=\"abc123\") → " + limiter.checkRateLimit("abc123"));
        System.out.println("getRateLimitStatus(\"abc123\") → " + limiter.getRateLimitStatus("abc123"));
    }
}