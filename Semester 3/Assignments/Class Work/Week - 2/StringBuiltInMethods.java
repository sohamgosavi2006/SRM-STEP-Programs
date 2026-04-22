
import java.util.ArrayList;


public class StringBuiltInMethods {

    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        // 1. Display original string length including spaces
        System.out.println("String Length : " + sampleText.length());
        // 2. Remove leading and trailing spaces, show new length
        System.out.println("String Length after Trim : " + sampleText.trim().length());
        // 3. Find and display the character at index 5 (empty)
        System.out.println("Charcter at index 5 : " + sampleText.charAt(5));
        // 4. Extract substring "Programming" from the text
        System.out.println("Substring : " + sampleText.substring(6, 17));
        // 5. Find the index of the word "Fun" [use indexOf(word)]
        System.out.println("Index of Fun : " + sampleText.indexOf("Fun"));
        // 6. Check if the string contains "Java" [.equals() is case-sensitive]
        System.out.println("String has Java : " + sampleText.equals("Java"));
        // 7. Check if the string starts with "Java" (after trimming) [use startsWith(word)]
        System.out.println("String First Word : " + sampleText.trim().startsWith("Java"));
        // 8. Check if the string ends with an exclamation mark
        System.out.println("String ends with '!' : " + sampleText.trim().endsWith("!"));
        // 9. Convert the entire string to uppercase
        System.out.println("String Upper Case" + sampleText.toUpperCase());
        // 10. Convert the entire string to lowercase
        System.out.println("String Upper Case" + sampleText.toLowerCase());

        // Display Output
        System.out.println("Count of Vowels of string = " + countVowels(sampleText));
        findAllOccurrences(sampleText, 'a');
    }
    // TODO: Method to count vowels in a string

    public static int countVowels(String text) {

        int vowelsCount = 0;
        int ch = ' ';

        // Convert to Lower Case
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelsCount++;
            }
        }

        return vowelsCount;
    }

    // TODO: Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {

        // Creating Array List
        ArrayList posList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            // .equals() is used for comparing strings
            if(text.charAt(i) == target)
             {
                posList.add(i);
             }
        }

        System.out.println("Positions of "+target+" is "+posList);

    }
}
