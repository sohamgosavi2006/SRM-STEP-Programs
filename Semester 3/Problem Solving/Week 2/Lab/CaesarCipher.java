import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result.append((char) ((c - 'A' + shift) % 26 + 'A'));
            } else if (c >= 'a' && c <= 'z') {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void displayAscii(String original, String encrypted) {
        System.out.printf("%-15s %-15s %-15s %-15s\n", "Char (Orig)", "ASCII", "Char (Enc)", "ASCII");
        for (int i = 0; i < original.length(); i++) {
            char orig = original.charAt(i);
            char enc = encrypted.charAt(i);
            System.out.printf("%-15s %-15d %-15s %-15d\n", orig, (int)orig, enc, (int)enc);
        }
    }

    public static boolean validate(String original, String decrypted) {
        return original.equals(decrypted);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to encrypt:");
        String text = sc.nextLine();
        System.out.println("Enter the shift value:");
        int shift = sc.nextInt();

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("\nOriginal Text: " + text);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
        System.out.println();

        displayAscii(text, encrypted);

        boolean valid = validate(text, decrypted);
        System.out.println("\nDecryption valid: " + valid);

        sc.close();
    }
}
