import java.util.Scanner;

public class CharTypeTable {
    public static String classifyChar(char ch) {
        int code = (int) ch;
        if (code >= 65 && code <= 90) code += 32;
        if (code < 97 || code > 122) return "Not a Letter";
        char c = (char) code;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "Vowel";
        return "Consonant";
    }

    public static String[][] analyzeString(String s) {
        int n = s.length();
        String[][] res = new String[n][2];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            res[i][0] = String.valueOf(ch);
            res[i][1] = classifyChar(ch);
        }
        return res;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-6s %-15s%n", "Char", "Type");
        System.out.println("----------------------");
        for (String[] row : table) {
            // show whitespace characters visibly
            String ch = row[0];
            if (ch.equals(" ")) ch = "' '";
            else if (ch.equals("\t")) ch = "'\\t'";
            else if (ch.equals("\n")) ch = "'\\n'";
            System.out.printf("%-6s %-15s%n", ch, row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] analysis = analyzeString(text);
        displayTable(analysis);
        sc.close();
    }
}
