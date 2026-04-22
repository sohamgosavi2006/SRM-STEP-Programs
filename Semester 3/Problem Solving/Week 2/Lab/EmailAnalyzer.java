import java.util.*;

public class EmailAnalyzer {

    public static boolean validateEmail(String email) {
        int atPos = email.indexOf('@');
        int lastAtPos = email.lastIndexOf('@');
        if (atPos == -1 || atPos != lastAtPos) return false;
        int dotPos = email.indexOf('.', atPos);
        if (dotPos == -1) return false;
        if (atPos == 0 || atPos == email.length() - 1) return false;
        return true;
    }

    public static String[] extractComponents(String email) {
        int atPos = email.indexOf('@');
        String username = email.substring(0, atPos);
        String domain = email.substring(atPos + 1);
        int dotPos = domain.lastIndexOf('.');
        String domainName = domain.substring(0, dotPos);
        String extension = domain.substring(dotPos + 1);
        return new String[]{username, domain, domainName, extension};
    }

    public static void analyzeStatistics(List<String> emails, List<Boolean> validFlags) {
        int validCount = 0, invalidCount = 0, totalUserLen = 0;
        Map<String, Integer> domainCount = new HashMap<>();

        for (int i = 0; i < emails.size(); i++) {
            if (validFlags.get(i)) {
                validCount++;
                String[] parts = extractComponents(emails.get(i));
                totalUserLen += parts[0].length();
                domainCount.put(parts[1], domainCount.getOrDefault(parts[1], 0) + 1);
            } else {
                invalidCount++;
            }
        }

        String mostCommonDomain = "-";
        int max = 0;
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostCommonDomain = entry.getKey();
            }
        }

        double avgUserLen = validCount > 0 ? (double) totalUserLen / validCount : 0;

        System.out.println("\n--- Email Statistics ---");
        System.out.println("Total Valid Emails: " + validCount);
        System.out.println("Total Invalid Emails: " + invalidCount);
        System.out.println("Most Common Domain: " + mostCommonDomain);
        System.out.println("Average Username Length: " + String.format("%.2f", avgUserLen));
    }

    public static void displayResults(List<String> emails, List<Boolean> validFlags) {
        System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s\n",
                "Email", "Username", "Domain", "Domain Name", "Extension", "Valid");
        for (int i = 0; i < emails.size(); i++) {
            String email = emails.get(i);
            boolean valid = validFlags.get(i);
            if (valid) {
                String[] parts = extractComponents(email);
                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s\n",
                        email, parts[0], parts[1], parts[2], parts[3], "Yes");
            } else {
                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s\n",
                        email, "-", "-", "-", "-", "No");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();
        List<Boolean> validFlags = new ArrayList<>();

        System.out.println("Enter email addresses (type 'done' to finish):");
        while (true) {
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("done")) break;
            emails.add(email);
            validFlags.add(validateEmail(email));
        }

        displayResults(emails, validFlags);
        analyzeStatistics(emails, validFlags);

        sc.close();
    }
}