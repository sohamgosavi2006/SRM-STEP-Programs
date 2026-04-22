
import java.util.Scanner;

public class StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// TODO: Ask user to enter a sentence with mixed formatting
        // TODO: Process the input using the following methods: 
        // 1. trim() - Remove extra spaces 
// 2. replace() - Replace all spaces with underscores 
// 3. replaceAll() - Remove all digits using regex 
// 4. split() - Split sentence into words array 
// 5. join() - Rejoin words with " | " separator 
// TODO: Create additional processing methods: 
// - Remove all punctuation 
// - Capitalize first letter of each word 
// - Reverse the order of words 
// - Count word frequency 

        System.out.println("Enter Text");
        String text = scanner.nextLine();

        // 1. trim() - Remove extra spaces 
        System.out.println("Trimmed Text : " + text.trim());
        // 2. replace() - Replace all spaces with underscores
        System.out.println("Replace space with '_' : " + text.replace(" ", "_"));
        // 3. replaceAll() - Remove all digits using regex pattern 
        //                   [0-9 is pattern for numbers from 0 to 9]
        System.out.println("Removing all Digits : " + text.replaceAll("[0-9]", ""));
        // 4. split() - Split sentence into words array
        // <> -> Diamond Operator
        String splitWords[] = text.split(" ");
        System.out.println("Words after Splitting - ");
        for ( String word : splitWords){
            System.out.println(word);
        }
        // 5. String.join() -> Rejoin words with " | " separator (delimeter)
        String joinWords[] = {"Java"," Programming"," Hello World"};
        String res = String.join("|",joinWords);
        System.out.println("Joined Sentence - " + res);

        System.out.println("Removed Punctuation - " + removePunctuation(text));
        System.out.println("Capitalised Word - " + capitalizeWords(text));
         System.out.println("Reversed Word - " + reverseWordOrder(text));


        scanner.close();
    }
    // TODO: Method to remove punctuation 
    public static String removePunctuation(String text) { 
        
        String result = text.replaceAll("\\p{Punct}", " ");

        return result;

    }
    // TODO: Method to capitalize each word 
    public static String capitalizeWords(String text) { 
        String result = text.toUpperCase();
        return result;
    }
    // TODO: Method to reverse word order 
    public static String reverseWordOrder(String text) {
        // Example -> Java is Fun 
        // Result -> Fun is Java

        String reverse="",word="";
        char ch=' ';
        for (int i = text.length()-1 ; i>=0;i--){
            ch = text.charAt(i);

            if(ch == ' '){
                // add word (which is currently reversed) to result
                // StringBuilder is a mutable (changeable) sequence of characters
                reverse += new StringBuilder(word).reverse().toString() + " ";
                word="";
            }
            else{
                word+=ch;
            }

        }

        reverse += new StringBuilder(word).reverse().toString();

        return reverse.trim();

    }
    // TODO: Method to count word frequency 
    public static void countWordFrequency(String text) {
            String word="";
            int count=0;
        char ch=' ';
        for (int i=0;i<text.length();i++){
            ch = text.charAt(i);

            if(ch == ' '){
                count++;
                word="";
            }
            else{
                word+=ch;
            }

        }
        System.out.println("Word Count -> "+count);
    }
}
