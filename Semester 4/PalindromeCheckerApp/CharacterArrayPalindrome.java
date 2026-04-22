package src;

public class CharacterArrayPalindrome {
    public static void main(String[] args) {
        String input = "Racecar"; // Mixed case example

        // Step 1: Normalization (Lowercasing for accuracy)
        String normalized = input.toLowerCase();

        // Step 2: Convert string to char[]
        char[] charArray = normalized.toCharArray();

        // Step 3: Execute Two-Pointer Logic
        boolean result = isPalindrome(charArray);

        System.out.println("Is  '" + input + "' a palindrome? " + result);
    }

    public static boolean isPalindrome(char[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Compare characters at current pointers
            if (arr[left] != arr[right]) {
                return false; // Exit early if mismatch found
            }
            left++;  // Move toward middle
            right--; // Move toward middle
        }
        return true;
    }
}
