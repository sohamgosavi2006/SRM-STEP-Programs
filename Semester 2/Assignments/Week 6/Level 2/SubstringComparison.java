import java.util.Scanner;

public class SubstringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Enter start index: ");
        int start = scanner.nextInt();
        System.out.println("Enter end index: ");
        int end = scanner.nextInt();
        String customSubstring = createSubstringCharAt(input, start, end);
        String builtInSubstring = input.substring(start, end);
        boolean substringMatch = compareStringsCharAt(customSubstring, builtInSubstring);
        System.out.println("Custom substring: " + customSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Substrings match: " + substringMatch);
        scanner.close();
    }

    public static String createSubstringCharAt(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareStringsCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}