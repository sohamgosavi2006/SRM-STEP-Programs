import java.util.Scanner;

public class ToLowerCaseProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String userText = sc.nextLine();
        
        String myLowerText = makeLowerCase(userText);
        String javaLowerText = userText.toLowerCase();
        
        boolean same = areStringsEqual(myLowerText, javaLowerText);
        
        System.out.println("My lowercase version: " + myLowerText);
        System.out.println("Java's lowercase version: " + javaLowerText);
        System.out.println("Do they match? " + same);
        
        sc.close();
    }
    
    public static String makeLowerCase(String str) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                newText.append((char) (letter + 32));
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