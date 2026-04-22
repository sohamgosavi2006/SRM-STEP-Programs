import java.util.Scanner;
import java.util.Arrays;

public class SplitText {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] customSplit(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0];
        }
        int delimiterCount = 0;
        char delimiter = ' ';
        for (int i = 0; i < getLength(str); i++) {
            if (str.charAt(i) == delimiter) {
                delimiterCount++;
            }
        }

        String[] result = new String[delimiterCount + 1];
        int currentPartIndex = 0;
        int startIndex = 0;

        for (int i = 0; i < getLength(str); i++) {
            if (str.charAt(i) == delimiter) {
                result[currentPartIndex] = str.substring(startIndex, i);
                currentPartIndex++;
                startIndex = i + 1;
            }
        }
        result[currentPartIndex] = str.substring(startIndex);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] customWords = customSplit(input);
        String[] splitWords = input.split(" ");

        System.out.println("Custom split:");
        for (String word : customWords) {
        System.out.println(word);
        }

        System.out.println("Built-in split:");
        for (String word : splitWords) {
            System.out.println(word);
        }

        if (Arrays.equals(customWords, splitWords)) {
            System.out.println("Both the splits are same.");
        } else {
            System.out.println("Both the splits are not same.");
        }

        sc.close();
    }
}
