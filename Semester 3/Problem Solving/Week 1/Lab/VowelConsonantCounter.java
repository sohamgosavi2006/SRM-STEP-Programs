import java.util.Scanner;

public class VowelConsonantCounter {
    public static String classifyChar(char ch) {
        int code = (int) ch;
        if (code >= 65 && code <= 90) code += 32;
        if (code < 97 || code > 122) return "Not a Letter";
        char c = (char) code;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "Vowel";
        return "Consonant";
    }

    public static int[] countVowelsConsonants(String s) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < s.length(); i++) {
            String t = classifyChar(s.charAt(i));
            if ("Vowel".equals(t)) vowels++;
            else if ("Consonant".equals(t)) consonants++;
        }
        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] res = countVowelsConsonants(text);
        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);
        sc.close();
    }
}
