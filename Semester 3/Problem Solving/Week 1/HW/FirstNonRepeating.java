import java.util.Scanner;

public class FirstNonRepeating {

    public static char findFirstNonRepeating(String text) {
        int[] freq = new int[256];
        int n = text.length();

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (freq[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char result = findFirstNonRepeating(text);
        if (result == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }
}
