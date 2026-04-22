import java.util.Scanner;

public class WordsWithLengths {

    private static String[] separateTextIntoWords(String inputText) {
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

    private static int getWordSize(String word) {
        int sizeCounter = 0;
        try {
            while (true) {
                word.charAt(sizeCounter);
                sizeCounter++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            return sizeCounter;
        }
    }

    private static String[][] createWordLengthPairs(String[] wordArray) {
        String[][] pairs = new String[wordArray.length][2];
        for (int index = 0; index < wordArray.length; index++) {
            pairs[index][0] = wordArray[index];
            pairs[index][1] = String.valueOf(getWordSize(wordArray[index]));
        }
        return pairs;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String userText = inputScanner.nextLine();
        String[] words = separateTextIntoWords(userText);
        String[][] wordLengths = createWordLengthPairs(words);
        System.out.println("Word\tLength");
        for (String[] pair : wordLengths) {
            System.out.println(pair[0] + "\t" + Integer.parseInt(pair[1]));
        }
    }
}