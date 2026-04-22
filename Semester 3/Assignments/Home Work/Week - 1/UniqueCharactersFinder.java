import java.util.Scanner;

public class UniqueCharactersFinder {

    private static int getTextLength(String inputText) {
        int length = 0;
        try {
            while (true) {
                inputText.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return length;
        }
    }

    private static char[] findUniqueChars(String inputText) {
        int textLength = getTextLength(inputText);
        char[] uniqueArray = new char[textLength];
        int uniqueCount = 0;
        for (int i = 0; i < textLength; i++) {
            char currentChar = inputText.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (inputText.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueArray[uniqueCount++] = currentChar;
            }
        }
        char[] finalUnique = new char[uniqueCount];
        System.arraycopy(uniqueArray, 0, finalUnique, 0, uniqueCount);
        return finalUnique;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();
        char[] uniqueChars = findUniqueChars(inputText);
        System.out.print("Unique characters: ");
        for (char ch : uniqueChars) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}