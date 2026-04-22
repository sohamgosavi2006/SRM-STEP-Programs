import java.util.Scanner;

public class CharArrayComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string for char array: ");
        String text = scanner.nextLine();
        char[] customChars = getCharacters(text);
        char[] builtInChars = text.toCharArray();
        boolean arraysMatch = compareCharArrays(customChars, builtInChars);
        System.out.println("Custom chars: " + new String(customChars));
        System.out.println("Built-in chars: " + new String(builtInChars));
        System.out.println("Arrays match: " + arraysMatch);
        scanner.close();
    }

    public static char[] getCharacters(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}