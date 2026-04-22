import java.util.Arrays;

public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        int originalLen = sampleText.length();
        String trimmed = sampleText.trim();
        int trimmedLen = trimmed.length();
        char chAt5 = sampleText.charAt(5);

        int progIndex = sampleText.indexOf("Programming");
        String progSub = progIndex >= 0 ? sampleText.substring(progIndex, progIndex + "Programming".length()) : "Not found";

        int funIndex = sampleText.indexOf("Fun");
        boolean containsJava = sampleText.contains("Java");
        boolean startsWithJava = trimmed.startsWith("Java");
        boolean endsWithBang = trimmed.endsWith("!");
        String upper = sampleText.toUpperCase();
        String lower = sampleText.toLowerCase();

        int vowelCount = countVowels(sampleText);

        int[] occA = findAllOccurrences(sampleText, 'a');
        int[] occG = findAllOccurrences(sampleText, 'g');

        System.out.println("Original string: \"" + sampleText + "\"");
        System.out.println("1. Original length (including spaces): " + originalLen);
        System.out.println("2. Trimmed string: \"" + trimmed + "\"");
        System.out.println("   Trimmed length: " + trimmedLen);
        System.out.println("3. Character at index 5: '" + (chAt5 == ' ' ? "\\u0020 (space)" : chAt5) + "'");
        System.out.println("4. Substring \"Programming\": " + progSub);
        System.out.println("5. Index of \"Fun\": " + funIndex);
        System.out.println("6. Contains \"Java\" (case-sensitive): " + containsJava);
        System.out.println("7. Starts with \"Java\" (after trimming): " + startsWithJava);
        System.out.println("8. Ends with '!': " + endsWithBang);
        System.out.println("9. Uppercase: " + upper);
        System.out.println("10. Lowercase: " + lower);
        System.out.println();
        System.out.println("Vowel count (a,e,i,o,u): " + vowelCount);
        System.out.println("Positions of 'a' (case-insensitive): " + Arrays.toString(occA));
        System.out.println("Positions of 'g' (case-insensitive): " + Arrays.toString(occG));
    }

    public static int countVowels(String text) {
        int cnt = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
        }
        return cnt;
    }

    public static int[] findAllOccurrences(String text, char target) {
        char t = target;
        if (t >= 'A' && t <= 'Z') t = (char)(t + 32);
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
            if (c == t) count++;
        }
        int[] pos = new int[count];
        int idx = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char lc = c;
            if (lc >= 'A' && lc <= 'Z') lc = (char)(lc + 32);
            if (lc == t) pos[idx++] = i;
        }
        return pos;
    }
}
