import java.util.Arrays;
import java.util.Scanner;

public class TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        String result = "";
        for (String word : words) {
            if (word.length() > 0) {
                result += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
            }
        }
        return result.trim();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;

        int sentenceCount = text.split("[.!?]").length;

        int charCount = text.replace(" ", "").length();

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        char mostCommon = ' ';
        int maxCount = 0;
        String noSpaces = text.replace(" ", "").toLowerCase();
        for (int i = 0; i < noSpaces.length(); i++) {
            char current = noSpaces.charAt(i);
            int count = 0;
            for (int j = 0; j < noSpaces.length(); j++) {
                if (noSpaces.charAt(j) == current) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostCommon = current;
            }
        }

        System.out.println("\n=== TEXT ANALYSIS ===");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: " + mostCommon);
    }

    public static String[] getWordsSorted(String text) {
        String cleaned = text.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleaned.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");

        System.out.print("Enter a paragraph: ");
        String paragraph = scanner.nextLine();

        String cleanedParagraph = cleanInput(paragraph);
        if (cleanedParagraph.isEmpty()) {
            System.out.println("Invalid input. Exiting...");
            scanner.close();
            return;
        }

        analyzeText(cleanedParagraph);

        System.out.println("\n=== SORTED WORDS ===");
        String[] sortedWords = getWordsSorted(cleanedParagraph);
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (String word : sortedWords) {
            if (word.equalsIgnoreCase(searchWord)) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "Word found!" : "Word not found.");

        scanner.close();
    }
}
