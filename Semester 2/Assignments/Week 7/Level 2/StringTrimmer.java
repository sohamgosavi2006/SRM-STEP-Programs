import java.util.Scanner;

class StringTrimmer {
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        int[] indexes = findTrimIndexes(text);
        String customTrim = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrim = text.trim();
        System.out.println("Custom trimmed string: \"" + customTrim + "\"");
        System.out.println("Built-in trimmed string: \"" + builtInTrim + "\"");
        System.out.println("Strings are equal: " + compareStrings(customTrim, builtInTrim));
        sc.close();
    }
}