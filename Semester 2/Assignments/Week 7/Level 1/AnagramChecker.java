import java.util.Scanner;

class AnagramChecker {
    public static boolean areAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }
        int[] freq = new int[256];
        for (int i = 0; i < text1.length(); i++) {
            freq[text1.charAt(i)]++;
            freq[text2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();
        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();
        System.out.println(areAnagrams(text1, text2) ? "Anagrams" : "Not anagrams");
        sc.close();
    }
}