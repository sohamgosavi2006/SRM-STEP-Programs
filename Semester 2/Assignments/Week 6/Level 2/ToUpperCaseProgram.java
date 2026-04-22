import java.util.Scanner;

public class ToUpperCaseProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String userText = sc.nextLine();
        
        String myUpperText = makeUpperCase(userText);
        String javaUpperText = userText.toUpperCase();
        
        boolean same = areStringsEqual(myUpperText, javaUpperText);
        
        System.out.println("My uppercase version: " + myUpperText);
        System.out.println("Java's uppercase version: " + javaUpperText);
        System.out.println("Do they match? " + same);
        
        sc.close();
    }
    
    public static String makeUpperCase(String str) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                newText.append((char) (letter - 32));
            } else {
                newText.append(letter);
            }
        }
        return newText.toString();
    }
    
    public static boolean areStringsEqual(String first, String second) {
        if (first.length() != second.length()) return false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) return false;
        }
        return true;
    }
}