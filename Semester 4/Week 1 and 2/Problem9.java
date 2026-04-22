import java.util.*;

public class Problem9 {

    static class Transaction {
        final long id;
        final double amount;
        final String merchant;
        final long timeMinutes; // 10:00 → 10*60 + 0

        Transaction(long id, double amount, String merchant, String time) {
            this.id = id;
            this.amount = amount;
            this.merchant = merchant;
            String[] parts = time.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            this.timeMinutes = h * 60 + m;
        }
    }

    static class FraudDetector {

        private final List<Transaction> transactions;

        public FraudDetector(List<Transaction> transactions) {
            this.transactions = new ArrayList<>(transactions);
        }

        public List<long[]> findTwoSum(double target) {
            Map<Double, Long> seen = new HashMap<>();
            List<long[]> pairs = new ArrayList<>();
            for (Transaction t : transactions) {
                double complement = target - t.amount;
                if (seen.containsKey(complement)) {
                    long[] p = {seen.get(complement), t.id};
                    pairs.add(p);
                } else {
                    seen.put(t.amount, t.id);
                }
            }
            return pairs;
        }

        public List<long[]> findTwoSumWithinHour(double target) {
            Map<Double, Long> seen = new HashMap<>();
            List<long[]> pairs = new ArrayList<>();
            for (Transaction t : transactions) {
                long now = t.timeMinutes;
                double complement = target - t.amount;
                if (seen.containsKey(complement)) {
                    pairLoop: for (Transaction earlier : transactions) {
                        if (earlier.id == seen.get(complement) &&
                            Math.abs(now - earlier.timeMinutes) <= 60) {
                            pairs.add(new long[]{earlier.id, t.id});
                            break pairLoop;
                        }
                    }
                } else {
                    seen.put(t.amount, t.id);
                }
            }
            return pairs;
        }

        public List<long[]> findKSum(int k, double target) {
            List<long[]> result = new ArrayList<>();
            List<Long> path = new ArrayList<>();
            kSumHelper(0, k, target, path, result);
            return result;
        }

        private void kSumHelper(int idx, int k, double target, List<Long> path, List<long[]> result) {
            if (k == 0 && target == 0.0) {
                long[] sol = new long[path.size()];
                for (int i = 0; i < path.size(); i++) {
                    sol[i] = path.get(i);
                }
                result.add(sol);
                return;
            }
            if (k == 0 || idx >= transactions.size() || target < 0.0) return;
            Transaction t = transactions.get(idx);
            path.add(t.id);
            kSumHelper(idx + 1, k - 1, target - t.amount, path, result);
            path.remove(path.size() - 1);
            kSumHelper(idx + 1, k, target, path, result);
        }

        public List<Map<String, Object>> detectDuplicates() {
            Map<String, Map<Double, Set<String>>> byMerchAmount = new HashMap<>();
            for (Transaction t : transactions) {
                String key = t.merchant;
                Map<Double, Set<String>> amts = byMerchAmount.computeIfAbsent(key, k -> new HashMap<>());
                Set<String> accounts = amts.computeIfAbsent(t.amount, k -> new HashSet<>());
                accounts.add(Long.toString(t.id)); // simulating account id
            }
            List<Map<String, Object>> dups = new ArrayList<>();
            for (Map.Entry<String, Map<Double, Set<String>>> merchEntry : byMerchAmount.entrySet()) {
                for (Map.Entry<Double, Set<String>> amtEntry : merchEntry.getValue().entrySet()) {
                    if (amtEntry.getValue().size() > 1) {
                        Map<String, Object> dup = new LinkedHashMap<>();
                        dup.put("amount", amtEntry.getKey());
                        dup.put("merchant", merchEntry.getKey());
                        dup.put("accounts", new ArrayList<>(amtEntry.getValue()));
                        dups.add(dup);
                    }
                }
            }
            return dups;
        }
    }

    public static void main(String[] args) {
        List<Transaction> txns = Arrays.asList(
            new Transaction(1, 500.0, "Store A", "10:00"),
            new Transaction(2, 300.0, "Store B", "10:15"),
            new Transaction(3, 200.0, "Store C", "10:30")
        );

        FraudDetector fd = new FraudDetector(txns);

        System.out.println("findTwoSum(target=500) → " + fd.findTwoSum(500.0));

        System.out.println("findTwoSumWithinHour(target=500) → " + fd.findTwoSumWithinHour(500.0));

        System.out.println("findKSum(k=3, target=1000) → " + fd.findKSum(3, 1000.0));

        System.out.println("detectDuplicates() → " + fd.detectDuplicates());
    }
}