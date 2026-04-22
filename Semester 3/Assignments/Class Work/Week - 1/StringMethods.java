import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter your favorite programming language: ");
        String language = sc.nextLine();
        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = sc.nextLine();

        String nameParts[] = fullName.trim().split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";
        int charCount = sentence.replace(" ", "").length();
        String langUpper = language.toUpperCase();

        System.out.println("\nSummary ");
        System.out.println("First Name " + firstName);
        System.out.println("Last Name " + lastName);
        System.out.println("Favorite Language " + langUpper);
        System.out.println("Sentence Character Count  " + charCount);

    }
}
