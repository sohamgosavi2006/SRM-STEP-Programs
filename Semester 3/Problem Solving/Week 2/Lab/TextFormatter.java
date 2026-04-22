import java.util.*;

public class TextFormatter {

    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (start < i) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < text.length()) {
            words.add(text.substring(start));
        }
        return words;
    }

    public static List<String> justifyText(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        int i = 0;
        while (i < words.size()) {
            int len = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && len + 1 + words.get(j).length() <= width) {
                len += 1 + words.get(j).length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            int gaps = j - i - 1;
            if (j == words.size() || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words.get(k));
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < width) sb.append(" ");
            } else {
                int spaces = (width - len) / gaps + 1;
                int extra = (width - len) % gaps;
                for (int k = i; k < j; k++) {
                    sb.append(words.get(k));
                    if (k < j - 1) {
                        for (int s = 0; s < spaces; s++) sb.append(" ");
                        if (extra > 0) {
                            sb.append(" ");
                            extra--;
                        }
                    }
                }
            }
            lines.add(sb.toString());
            i = j;
        }
        return lines;
    }

    public static List<String> centerAlign(List<String> words, int width) {
        List<String> lines = new ArrayList<>();
        int i = 0;
        while (i < words.size()) {
            int len = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && len + 1 + words.get(j).length() <= width) {
                len += 1 + words.get(j).length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = i; k < j; k++) {
                sb.append(words.get(k));
                if (k < j - 1) sb.append(" ");
            }
            int padding = width - sb.length();
            int left = padding / 2;
            int right = padding - left;
            StringBuilder centered = new StringBuilder();
            for (int p = 0; p < left; p++) centered.append(" ");
            centered.append(sb);
            for (int p = 0; p < right; p++) centered.append(" ");
            lines.add(centered.toString());
            i = j;
        }
        return lines;
    }

    public static long measureWithBuilder(List<String> words, int width) {
        long start = System.nanoTime();
        justifyText(words, width);
        long end = System.nanoTime();
        return end - start;
    }

    public static long measureWithConcat(List<String> words, int width) {
        long start = System.nanoTime();
        int i = 0;
        while (i < words.size()) {
            String line = "";
            int len = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && len + 1 + words.get(j).length() <= width) {
                len += 1 + words.get(j).length();
                j++;
            }
            for (int k = i; k < j; k++) {
                line = line + words.get(k);
                if (k < j - 1) line = line + " ";
            }
            i = j;
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void displayResults(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            System.out.printf("Line %d (%d chars): %s\n", i + 1, line.length(), line);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.nextLine();
        System.out.println("Enter desired line width:");
        int width = sc.nextInt();

        List<String> words = splitWords(text);

        List<String> justified = justifyText(words, width);
        List<String> centered = centerAlign(words, width);

        System.out.println("\nOriginal Text:\n" + text);
        System.out.println("\n--- Justified Text ---");
        displayResults(justified);
        System.out.println("\n--- Center-Aligned Text ---");
        displayResults(centered);

        long timeBuilder = measureWithBuilder(words, width);
        long timeConcat = measureWithConcat(words, width);

        System.out.println("\n--- Performance Analysis ---");
        System.out.println("StringBuilder Time (ns): " + timeBuilder);
        System.out.println("String Concatenation Time (ns): " + timeConcat);

        sc.close();
    }
}