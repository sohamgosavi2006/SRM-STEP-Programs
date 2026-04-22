import java.util.*;

public class TextCompression {

    public static char[] getUniqueChars(String text) {
        StringBuilder unique = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (unique.indexOf(String.valueOf(c)) == -1) {
                unique.append(c);
            }
        }
        char[] arr = new char[unique.length()];
        for (int i = 0; i < unique.length(); i++) arr[i] = unique.charAt(i);
        return arr;
    }

    public static int[] countFrequencies(String text, char[] uniqueChars) {
        int[] freq = new int[uniqueChars.length];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < uniqueChars.length; j++) {
                if (c == uniqueChars[j]) {
                    freq[j]++;
                    break;
                }
            }
        }
        return freq;
    }

    public static String[][] createCodes(char[] uniqueChars, int[] freq) {
        String[][] codes = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            codes[i][0] = String.valueOf(uniqueChars[i]);
            codes[i][1] = Integer.toString(i, uniqueChars.length + 1);
        }
        return codes;
    }

    public static String compress(String text, String[][] codes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < codes.length; j++) {
                if (String.valueOf(c).equals(codes[j][0])) {
                    sb.append(codes[j][1]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static String decompress(String compressed, String[][] codes) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < compressed.length()) {
            for (int j = 0; j < codes.length; j++) {
                String code = codes[j][1];
                if (compressed.startsWith(code, i)) {
                    sb.append(codes[j][0]);
                    i += code.length();
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void displayAnalysis(String text, char[] uniqueChars, int[] freq, String[][] codes, String compressed, String decompressed) {
        System.out.println("Character Frequency:");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.println(uniqueChars[i] + " : " + freq[i]);
        }
        System.out.println("\nCompression Codes:");
        for (int i = 0; i < codes.length; i++) {
            System.out.println(codes[i][0] + " -> " + codes[i][1]);
        }
        System.out.println("\nOriginal Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);
        double ratio = ((double) compressed.length() / text.length()) * 100;
        System.out.println("Compression Efficiency: " + String.format("%.2f", 100 - ratio) + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        char[] uniqueChars = getUniqueChars(text);
        int[] freq = countFrequencies(text, uniqueChars);
        String[][] codes = createCodes(uniqueChars, freq);
        String compressed = compress(text, codes);
        String decompressed = decompress(compressed, codes);

        displayAnalysis(text, uniqueChars, freq, codes, compressed, decompressed);

        sc.close();
    }
}