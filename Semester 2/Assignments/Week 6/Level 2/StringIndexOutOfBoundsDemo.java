import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine();
        generateStringIndexOutOfBounds(text);
        handleStringIndexOutOfBounds(text);
        scanner.close();
    }

    public static void generateStringIndexOutOfBounds(String text) {
        text.charAt(text.length() + 1);
    }

    public static void handleStringIndexOutOfBounds(String text) {
        try {
            text.charAt(text.length() + 1);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}