import java.util.Scanner;

public class TextCaseConversion {

    public static char toUpperChar(char c) {
        if (c >= 97 && c <= 122) {
            return (char)(c - 32);
        }
        return c;
    }

    public static char toLowerChar(char c) {
        if (c >= 65 && c <= 90) {
            return (char)(c + 32);
        }
        return c;
    }

    public static String toUpperCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(toUpperChar(text.charAt(i)));
        }
        return result.toString();
    }

    public static String toLowerCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(toLowerChar(text.charAt(i)));
        }
        return result.toString();
    }

    public static String toTitleCase(String text) {
        StringBuilder result = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                result.append(c);
                newWord = true;
            } else {
                if (newWord) {
                    result.append(toUpperChar(c));
                    newWord = false;
                } else {
                    result.append(toLowerChar(c));
                }
            }
        }
        return result.toString();
    }

    public static boolean compareWithBuiltIn(String text) {
        boolean upperMatch = toUpperCase(text).equals(text.toUpperCase());
        boolean lowerMatch = toLowerCase(text).equals(text.toLowerCase());
        return upperMatch && lowerMatch;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.nextLine();

        String manualUpper = toUpperCase(text);
        String manualLower = toLowerCase(text);
        String manualTitle = toTitleCase(text);
        String builtInUpper = text.toUpperCase();
        String builtInLower = text.toLowerCase();
        boolean same = compareWithBuiltIn(text);

        System.out.printf("%-20s %-20s %-20s\n", "Conversion", "Manual Result", "Built-in Result");
        System.out.printf("%-20s %-20s %-20s\n", "Uppercase", manualUpper, builtInUpper);
        System.out.printf("%-20s %-20s %-20s\n", "Lowercase", manualLower, builtInLower);
        System.out.printf("%-20s %-20s %-20s\n", "Title Case", manualTitle, "-");
        System.out.println("Do manual and built-in results match? " + same);

        sc.close();
    }
}
