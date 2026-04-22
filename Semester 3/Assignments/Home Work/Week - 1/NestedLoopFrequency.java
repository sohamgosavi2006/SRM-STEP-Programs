import java.util.Scanner;

public class NestedLoopFrequency {

    private static String[] getCharFrequencies(String inputText) {
        char[] charArray = inputText.toCharArray();
        int[] frequencyArray = new int[charArray.length];
        int validCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') continue;
            frequencyArray[i] = 1;
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    frequencyArray[i]++;
                    charArray[j] = '0';
                }
            }
            validCount++;
        }
        String[] results = new String[validCount * 2];
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0') {
                results[index++] = String.valueOf(charArray[i]);
                results[index++] = String.valueOf(frequencyArray[i]);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();
        String[] frequencies = getCharFrequencies(inputText);
        System.out.println("Character frequencies:");
        for (int i = 0; i < frequencies.length; i += 2) {
            System.out.println(frequencies[i] + ": " + frequencies[i + 1]);
        }
    }
}