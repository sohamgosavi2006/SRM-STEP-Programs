import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Clean the string: lowercase and alphanumeric only
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindromeRecursive(cleaned, 0, cleaned.length() - 1)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive method to check palindrome status
     * @param str The cleaned string
     * @param start Starting index
     * @param end Ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base Condition 1: If pointers cross or meet, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Base Condition 2: If characters at current pointers don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Check the inner substring by moving pointers inward
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}