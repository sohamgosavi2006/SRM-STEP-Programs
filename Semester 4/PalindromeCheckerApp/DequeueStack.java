import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Deque-Based Palindrome Checker ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Core logic using Deque data structure
     */
    public static boolean isPalindrome(String text) {
        // Clean the string: remove non-alphanumeric and convert to lowercase
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize Deque
        Deque<Character> deque = new ArrayDeque<>();

        // Step 1: Insert all characters into the Deque
        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch);
        }

        // Step 2: Compare front and rear
        // A palindrome remains a palindrome as you strip the ends
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false; // Mismatch found
            }
        }

        return true; // All pairs matched
    }
}