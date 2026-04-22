import java.util.*;
public class TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        return input;
    }
    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replace(" ", "").length();

        String longestWord = "";
        for (String w : words) {
            if (w.length() > longestWord.length()) {
                longestWord = w;
            }
        }

        System.out.println("Word Count -> " + wordCount);
        System.out.println("Sentence Count ->  " + sentenceCount);
        System.out.println("Character Count -> " + charCount);
        System.out.println("Longest Word -> " + longestWord);
    }

    public static String[] getWordsSorted(String text) {
        text = text.replaceAll("[^a-zA-Z ]", "");
        String[] words = text.split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String Pool -> It is a storage area for string literals
        // String s1 = "Hello";   // Stored in String Pool

        System.out.println("Text Processing System");
        System.out.print("Enter a paragraph -> ");
        String paragraph = sc.nextLine();

        paragraph = cleanInput(paragraph);
        analyzeText(paragraph);

        String[] sortedWords = getWordsSorted(paragraph);
        System.out.println("Words in Alphabetical Order: " + Arrays.toString(sortedWords));

        System.out.print("Search for a word: ");
        String search = sc.nextLine();
        boolean found = false;
        for (String w : sortedWords) {
            if (w.equalsIgnoreCase(search)) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "Word found." : "Word not found.");
    }
}
