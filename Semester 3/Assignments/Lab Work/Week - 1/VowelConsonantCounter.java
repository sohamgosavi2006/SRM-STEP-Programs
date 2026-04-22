import java.util.Scanner;

public class VowelConsonantCounter {

    private static String classifyCharacter(char inputChar) {
        if (inputChar >= 'A' && inputChar <= 'Z') {
            inputChar = (char) (inputChar + 32);
        }
        if (inputChar == 'a' || inputChar == 'e' || inputChar == 'i' || inputChar == 'o' || inputChar == 'u') {
            return "Vowel";
        } else if (inputChar >= 'a' && inputChar <= 'z') {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }

    private static int[] countVowelsAndConsonants(String inputText) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int position = 0; position < inputText.length(); position++) {
            String charType = classifyCharacter(inputText.charAt(position));
            if (charType.equals("Vowel")) {
                vowelCount++;
            } else if (charType.equals("Consonant")) {
                consonantCount++;
            }
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String userText = inputScanner.nextLine();
        int[] counts = countVowelsAndConsonants(userText);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}