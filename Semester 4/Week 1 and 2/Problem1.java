import java.util.*;

public class Problem1 {

    private final Set<String> takenUsernames;
    private final Map<String, Integer> attemptCount;

    public Problem1() {
        takenUsernames = new HashSet<>();
        attemptCount = new HashMap<>();
    }

    public boolean register(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (takenUsernames.contains(username)) {
            return false;
        }
        takenUsernames.add(username);
        return true;
    }

    public boolean checkAvailability(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        attemptCount.merge(username, 1, Integer::sum);
        return !takenUsernames.contains(username);
    }

    public List<String> suggestAlternatives(String username) {
        if (username == null || username.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> suggestions = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String candidate = username + i;
            if (!takenUsernames.contains(candidate)) {
                suggestions.add(candidate);
                if (suggestions.size() >= 3) break;
            }
        }

        if (suggestions.size() < 3) {
            String withDot  = username.replace("_", ".").replace("-", ".");
            String withUnd  = username.replace(".", "_");
            String withDash = username.replace(".", "-");

            for (String cand : Arrays.asList(withDot, withUnd, withDash)) {
                if (!takenUsernames.contains(cand)) {
                    suggestions.add(cand);
                    if (suggestions.size() >= 3) break;
                }
            }
        }

        return suggestions;
    }

    public String getMostAttempted() {
        if (attemptCount.isEmpty()) {
            return null;
        }
        return attemptCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public int getAttemptCount(String username) {
        return attemptCount.getOrDefault(username, 0);
    }

    public static void main(String[] args) {
        Problem1 checker = new Problem1();

        checker.register("john_doe");
        checker.register("jane_smith");
        checker.register("admin");

        System.out.println("checkAvailability(\"john_doe\") → " + checker.checkAvailability("john_doe"));
        System.out.println("checkAvailability(\"jane_smith\") → " + checker.checkAvailability("jane_smith"));
        System.out.println("checkAvailability(\"someone_new\") → " + checker.checkAvailability("someone_new"));

        System.out.println("suggestAlternatives(\"john_doe\") → " + checker.suggestAlternatives("john_doe"));

        for (int i = 0; i < 10543; i++) {
            checker.checkAvailability("admin");
        }

        System.out.println("getMostAttempted() → " + checker.getMostAttempted() + " (" + checker.getAttemptCount("admin") + " attempts)");
    }
}