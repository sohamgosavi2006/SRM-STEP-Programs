import java.util.Scanner;

public class CharFrequencyCounter {

    private static String[][] getCharFrequencies(String inputText) {
        int[] charFrequency = new int[256];
        for (int i = 0; i < inputText.length(); i++) {
            charFrequency[inputText.charAt(i)]++;
        }
        int nonZeroCount = 0;
        for (int freq : charFrequency) {
            if (freq > 0) {
                nonZeroCount++;
            }
        }
        String[][] frequencyResults = new String[nonZeroCount][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (charFrequency[i] > 0) {
                frequencyResults[index][0] = String.valueOf((char) i);
                frequencyResults[index][1] = String.valueOf(charFrequency[i]);
                index++;
            }
        }
        return frequencyResults;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();
        String[][] frequencies = getCharFrequencies(inputText);
        System.out.println("Character frequencies:");
        for (String[] pair : frequencies) {
            System.out.println(pair[0] + ": " + pair[1]);
        }
    }
}