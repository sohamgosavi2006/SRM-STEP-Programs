import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            System.out.println("Character: " + ch + " | ASCII: " + ascii);
            System.out.println("Type: " + classifyCharacter(ch));

            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Upper: " + upper + " (" + (int) upper + ")");
                System.out.println("Lower: " + lower + " (" + (int) lower + ")");
                System.out.println("Difference: " + Math.abs((int) upper - (int) lower));
            }
            System.out.println();
        }

        System.out.println("Caesar Cipher (shift 3): " + caesarCipher(input, 3));

        System.out.println("\nASCII Table (65–90):");
        displayASCIITable(65, 90);

        int[] asciiArr = stringToASCII(input);
        System.out.print("\nASCII Array: ");
        for (int code : asciiArr) System.out.print(code + " ");
        System.out.println("\nBack to String: " + asciiToString(asciiArr));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        else if (Character.isLowerCase(ch)) return (char) (ch - 32);
        else return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) arr[i] = text.charAt(i);
        return arr;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) sb.append((char) val);
        return sb.toString();
    }
}