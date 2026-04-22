import java.util.Scanner;

public class FrequencyWithUnique {

    private static char[] getUniqueChars(String inputText) {
        char[] uniqueArray = new char[inputText.length()];
        int uniqueCount = 0;
        for (int i = 0; i < inputText.length(); i++) {
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

    private static String[][] getFrequencies(String inputText) {
        int[] charFrequency = new int[256];
        for (int i = 0; i < inputText.length(); i++) {
            charFrequency[inputText.charAt(i)]++;
        }
        char[] uniqueChars = getUniqueChars(inputText);
        String[][] frequencyResults = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            frequencyResults[i][0] = String.valueOf(ch);
            frequencyResults[i][1] = String.valueOf(charFrequency[ch]);
        }
        return frequencyResults;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();
        String[][] frequencies = getFrequencies(inputText);
        System.out.println("Character frequencies:");
        for (String[] pair : frequencies) {
            System.out.println(pair[0] + ": " + pair[1]);
        }
    }
}