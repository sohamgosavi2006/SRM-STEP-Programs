import java.util.Scanner;

/**
 * Service class to encapsulate Palindrome logic.
 * This demonstrates the Single Responsibility Principle.
 */
class PalindromeService {

    /**
     * Encapsulated method to check if a string is a palindrome.
     * Logic: Internal character array comparison.
     */
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Preprocessing (Internal to the service)
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArray = cleaned.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/**
 * Main Application Class
 */
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the Service Object (OOP approach)
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter text to validate: ");
        String userInput = scanner.nextLine();

        // Calling the object's method
        boolean isPalindrome = service.checkPalindrome(userInput);

        if (isPalindrome) {
            System.out.println("Result: '" + userInput + "' is a valid palindrome.");
        } else {
            System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}