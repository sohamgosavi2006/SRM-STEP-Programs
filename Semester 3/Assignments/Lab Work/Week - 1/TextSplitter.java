import java.util.Scanner;

public class TextSplitter {

    private static int getStringSize(String textToMeasure) {
        int sizeCounter = 0;
        try {
            while (true) {
                textToMeasure.charAt(sizeCounter);
                sizeCounter++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            return sizeCounter;
        }
    }

    private static String[] divideTextIntoWords(String inputText) {
        int textSize = getStringSize(inputText);
        int wordCounter = 1;
        for (int position = 0; position < textSize; position++) {
            if (inputText.charAt(position) == ' ') {
                wordCounter++;
            }
        }
        String[] wordList = new String[wordCounter];
        int[] spacePositions = new int[wordCounter + 1];
        spacePositions[0] = 0;
        int spaceIndex = 1;
        for (int position = 0; position < textSize; position++) {
            if (inputText.charAt(position) == ' ') {
                spacePositions[spaceIndex++] = position + 1;
            }
        }
        spacePositions[spaceIndex] = textSize;
        for (int wordIndex = 0; wordIndex < wordCounter; wordIndex++) {
            int startPos = spacePositions[wordIndex];
            int endPos = spacePositions[wordIndex + 1];
            StringBuilder wordBuilder = new StringBuilder();
            for (int charPos = startPos; charPos < endPos; charPos++) {
                wordBuilder.append(inputText.charAt(charPos));
            }
            wordList[wordIndex] = wordBuilder.toString().trim();
        }
        return wordList;
    }

    private static boolean compareWordArrays(String[] firstArray, String[] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        }
        for (int index = 0; index < firstArray.length; index++) {
            if (!firstArray[index].equals(secondArray[index])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String userText = inputScanner.nextLine();
        String[] customWords = divideTextIntoWords(userText);
        String[] builtInWords = userText.split(" ");
        boolean arraysMatch = compareWordArrays(customWords, builtInWords);
        System.out.println("Custom split words:");
        for (String word : customWords) {
            System.out.print(word + " ");
        }
        System.out.println("\nBuilt-in split words:");
        for (String word : builtInWords) {
            System.out.print(word + " ");
        }
        System.out.println("\nArrays match: " + arraysMatch);
    }
}