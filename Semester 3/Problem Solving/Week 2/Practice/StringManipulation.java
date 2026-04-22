import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        String original = input;
        String trimmed = input.trim();
        String replacedSpaces = trimmed.replace(" ", "_");
        String removedDigits = trimmed.replaceAll("\\d", "");
        String[] words = removedDigits.split("\\s+");
        String joinedWithPipe = String.join(" | ", words);

        String noPunct = removePunctuation(trimmed);
        String capitalized = capitalizeWords(noPunct);
        String reversedOrder = reverseWordOrder(noPunct);

        System.out.println();
        System.out.println("Original:            " + original);
        System.out.println("Trimmed:             " + trimmed);
        System.out.println("Spaces->underscores: " + replacedSpaces);
        System.out.println("Digits removed:      " + removedDigits);
        System.out.println("Split words:         " + Arrays.toString(words));
        System.out.println("Rejoined ( | ):      " + joinedWithPipe);
        System.out.println("Without punctuation: " + noPunct);
        System.out.println("Capitalized words:   " + capitalized);
        System.out.println("Reversed word order: " + reversedOrder);
        System.out.println();
        System.out.println("Word frequency:");
        countWordFrequency(noPunct);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("[\\p{Punct}]", "");
    }

    public static String capitalizeWords(String text) {
        String[] parts = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String w = parts[i];
            if (w.length() == 0) continue;
            String cap = w.substring(0, 1).toUpperCase();
            if (w.length() > 1) cap += w.substring(1).toLowerCase();
            if (sb.length() > 0) sb.append(' ');
            sb.append(cap);
        }
        return sb.toString();
    }

    public static String reverseWordOrder(String text) {
        String[] parts = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            if (parts[i].length() == 0) continue;
            if (sb.length() > 0) sb.append(' ');
            sb.append(parts[i]);
        }
        return sb.toString();
    }

    public static void countWordFrequency(String text) {
        String cleaned = text.toLowerCase().replaceAll("[\\p{Punct}]", "");
        String[] parts = cleaned.trim().split("\\s+");
        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String w : parts) {
            if (w.length() == 0) continue;
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        if (freq.isEmpty()) {
            System.out.println("  (no words)");
            return;
        }
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            System.out.println("  " + e.getKey() + " : " + e.getValue());
        }
    }
}
