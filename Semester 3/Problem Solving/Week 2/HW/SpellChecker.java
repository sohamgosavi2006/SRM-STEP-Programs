import java.util.Scanner;

public class SpellChecker {

    public static String[] splitSentence(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        String[] words = new String[count + 1];
        int start = 0, index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = text.substring(start);
        return words;
    }

    public static int stringDistance(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int minLen = Math.min(lenA, lenB);
        int distance = Math.abs(lenA - lenB);
        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static String findClosestWord(String word, String[] dictionary) {
        String suggestion = word;
        int minDist = Integer.MAX_VALUE;
        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                suggestion = dictWord;
            }
        }
        if (minDist <= 2) {
            return suggestion;
        }
        return word;
    }

    public static void displayResults(String[] words, String[] dictionary) {
        System.out.printf("%-15s %-15s %-10s %-15s\n", "Word", "Suggestion", "Distance", "Status");
        for (String word : words) {
            String suggestion = findClosestWord(word, dictionary);
            int distance = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            String status = word.equalsIgnoreCase(suggestion) ? "Correct" : "Misspelled";
            System.out.printf("%-15s %-15s %-10d %-15s\n", word, suggestion, distance, status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dictionary = {"hello", "world", "java", "spell", "checker", "program"};
        String sentence = sc.nextLine();
        String[] words = splitSentence(sentence);
        displayResults(words, dictionary);

        sc.close();
    }
}