import java.util.*;

public class PasswordAnalyzer {

    public static int[] analyzePassword(String password) {
        int upper = 0, lower = 0, digits = 0, special = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int ascii = (int) c;
            if (ascii >= 65 && ascii <= 90) upper++;
            else if (ascii >= 97 && ascii <= 122) lower++;
            else if (ascii >= 48 && ascii <= 57) digits++;
            else if (ascii >= 33 && ascii <= 126) special++;
        }
        return new int[]{upper, lower, digits, special};
    }

    public static int calculateScore(String password, int[] counts) {
        int score = 0;
        if (password.length() > 8) score += (password.length() - 8) * 2;
        if (counts[0] > 0) score += 10;
        if (counts[1] > 0) score += 10;
        if (counts[2] > 0) score += 10;
        if (counts[3] > 0) score += 10;
        String lower = password.toLowerCase();
        if (lower.contains("123") || lower.contains("abc") || lower.contains("qwerty")) score -= 10;
        return score;
    }

    public static String strengthLevel(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    public static String generatePassword(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append((char) (rand.nextInt(26) + 65));
        sb.append((char) (rand.nextInt(26) + 97));
        sb.append((char) (rand.nextInt(10) + 48));
        sb.append((char) (rand.nextInt(15) + 33));
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{};:,.<>?";
        for (int i = 4; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        List<Character> charsList = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) charsList.add(sb.charAt(i));
        Collections.shuffle(charsList);
        StringBuilder shuffled = new StringBuilder();
        for (char c : charsList) shuffled.append(c);
        return shuffled.toString();
    }

    public static void displayResults(String[] passwords) {
        System.out.printf("%-15s %-8s %-8s %-8s %-8s %-8s %-8s %-10s\n", "Password", "Length", "Upper", "Lower", "Digits", "Special", "Score", "Strength");
        for (String pwd : passwords) {
            int[] counts = analyzePassword(pwd);
            int score = calculateScore(pwd, counts);
            String strength = strengthLevel(score);
            System.out.printf("%-15s %-8d %-8d %-8d %-8d %-8d %-8d %-10s\n", pwd, pwd.length(), counts[0], counts[1], counts[2], counts[3], score, strength);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] passwords = new String[n];
        for (int i = 0; i < n; i++) passwords[i] = sc.nextLine();
        displayResults(passwords);
        int len = sc.nextInt();
        String strongPwd = generatePassword(len);
        System.out.println("Generated Strong Password: " + strongPwd);

        sc.close();
    }
}