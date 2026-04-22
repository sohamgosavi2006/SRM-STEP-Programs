import java.util.Scanner;

public class StringLengthFinder {

    private static int calculateStringLength(String inputString) {
        int charCount = 0;
        try {
            while (true) {
                inputString.charAt(charCount);
                charCount++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            return charCount;
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String userText = inputScanner.next();
        int customLength = calculateStringLength(userText);
        int builtInLength = userText.length();
        System.out.println("Custom length: " + customLength);
        System.out.println("Built-in length: " + builtInLength);
    }
}