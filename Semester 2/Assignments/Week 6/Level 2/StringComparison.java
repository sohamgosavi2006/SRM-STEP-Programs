import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter second string: ");
        String str2 = scanner.nextLine();
        boolean charAtResult = compareStringsCharAt(str1, str2);
        boolean equalsResult = str1.equals(str2);
        System.out.println("charAt comparison: " + charAtResult);
        System.out.println("equals comparison: " + equalsResult);
        System.out.println("Results match: " + (charAtResult == equalsResult));
        scanner.close();
    }

    public static boolean compareStringsCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}