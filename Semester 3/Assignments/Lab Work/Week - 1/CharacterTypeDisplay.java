import java.util.Scanner;

public class CharacterTypeDisplay {

    private static String determineCharType(char inputChar) {
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

    private static String[][] mapCharsToTypes(String inputText) {
        String[][] charTypes = new String[inputText.length()][2];
        for (int position = 0; position < inputText.length(); position++) {
            char currentChar = inputText.charAt(position);
            charTypes[position][0] = String.valueOf(currentChar);
            charTypes[position][1] = determineCharType(currentChar);
        }
        return charTypes;
    }

    private static void printCharTypesTable(String[][] charTypes) {
        System.out.println("Character\tType");
        for (String[] pair : charTypes) {
            System.out.println(pair[0] + "\t\t" + pair[1]);
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String userText = inputScanner.nextLine();
        String[][] types = mapCharsToTypes(userText);
        printCharTypesTable(types);
    }
}