import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case & Space Insensitive Checker ---");
        System.out.print("Enter a string or phrase: ");
        String input = scanner.nextLine();

        if (isNormalizedPalindrome(input)) {
            System.out.println("Result: Success! It is a palindrome (after normalization).");
        } else {
            System.out.println("Result: Failure. It is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Normalizes the string and checks for palindrome property
     */
    public static boolean isNormalizedPalindrome(String text) {
        if (text == null) return false;

        // Step 1: Normalize String
        // [^a-zA-Z0-9] means "anything that is NOT a letter or a number"
        // replaceAll replaces those matches with an empty string
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Normalized String: " + cleaned);

        // Step 2: Use two-pointer approach to validate
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}