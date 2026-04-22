import java.util.Scanner;

public class ShortestLongestFinder {

    private static String[] breakTextIntoWords(String inputText) {
        int textSize = inputText.length();
        int wordCounter = 1;
        for (int position = 0; position < textSize; position++) {
            if (inputText.charAt(position) == ' ') {
                wordCounter++;
            }
        }
        String[] wordList = new String[wordCounter];
        int currentWordIndex = 0;
        StringBuilder currentWord = new StringBuilder();
        for (int position = 0; position < textSize; position++) {
            char currentChar = inputText.charAt(position);
            if (currentChar != ' ') {
                currentWord.append(currentChar);
            } else {
                if (currentWord.length() > 0) {
                    wordList[currentWordIndex++] = currentWord.toString();
                    currentWord.setLength(0);
                }
            }
        }
        if (currentWord.length() > 0) {
            wordList[currentWordIndex] = currentWord.toString();
        }
        return wordList;
    }

    private static int measureWordLength(String word) {
        int lengthCounter = 0;
        try {
            while (true) {
                word.charAt(lengthCounter);
                lengthCounter++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            return lengthCounter;
        }
    }

    private static String[][] pairWordsWithLengths(String[] words) {
        String[][] lengthPairs = new String[words.length][2];
        for (int index = 0; index < words.length; index++) {
            lengthPairs[index][0] = words[index];
            lengthPairs[index][1] = String.valueOf(measureWordLength(words[index]));
        }
        return lengthPairs;
    }

    private static int[] findExtremeLengths(String[][] wordLengthPairs) {
        int shortestLength = Integer.MAX_VALUE;
        int longestLength = Integer.MIN_VALUE;
        for (String[] pair : wordLengthPairs) {
            int currentLength = Integer.parseInt(pair[1]);
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
            }
        }
        return new int[]{shortestLength, longestLength};
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String userText = inputScanner.nextLine();
        String[] words = breakTextIntoWords(userText);
        String[][] wordLengths = pairWordsWithLengths(words);
        int[] extremes = findExtremeLengths(wordLengths);
        System.out.println("Shortest length: " + extremes[0]);
        System.out.println("Longest length: " + extremes[1]);
    }
}