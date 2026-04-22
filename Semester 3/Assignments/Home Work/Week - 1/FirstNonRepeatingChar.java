import java.util.Scanner;

public class FirstNonRepeatingChar {

    private static char findFirstNonRepeat(String inputText) {
        int[] charFrequency = new int[256];
        for (int i = 0; i < inputText.length(); i++) {
            charFrequency[inputText.charAt(i)]++;
        }
        for (int i = 0; i < inputText.length(); i++) {
            if (charFrequency[inputText.charAt(i)] == 1) {
                return inputText.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();
        char resultChar = findFirstNonRepeat(inputText);
        if (resultChar != '\0') {
            System.out.println("First non-repeating character: " + resultChar);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}