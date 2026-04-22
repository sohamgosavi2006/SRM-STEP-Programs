import java.util.Scanner; 
public class ASCIIProcessor { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Enter a Sentence");
        String sentence = scanner.nextLine();

        char ch =' ';
        for(int i=0 ; i<sentence.length();i++){
            ch = sentence.charAt(i);

            System.out.println("Character : "+ch+" , ASCII Code : "+(int)ch);

            if(Character.isUpperCase(ch)){
                System.out.println("Character "+ch+" is Upper Case");
            }
            else if(Character.isLowerCase(ch)){
                System.out.println("Character "+ch+" is Lower Case");
            }
            else if(Character.isDigit(ch)){
                System.out.println("Character "+ch+" is Digit");
            }
            if(Character.isLetterOrDigit(ch)){
                System.out.println("Character "+ch+" is Letter or Digit");
            }
            else{
                System.out.println("Character "+ch+" is Special Character");
            }

            if(Character.isLetter(ch)){
                System.out.println("ASCII Upper Case "+ Character.toUpperCase(ch) + 
                " is : " + (int)Character.toUpperCase(ch));
                System.out.println("ASCII Lower Case "+ Character.toLowerCase(ch) + 
                " is : " + (int)Character.toLowerCase(ch));
            }

            if(Character.isLetter(ch)){
                int diff = Math.abs(((int)Character.toLowerCase(ch)) - ((int)Character.toUpperCase(ch)));
                System.out.println("ASCII Difference Of "+ Character.toLowerCase(ch) + 
                " and " + Character.toUpperCase(ch) + " is " + diff);
            }
        }

        scanner.close(); 
    } 

    public static String classifyCharacter(char ch) { 
        if(Character.isUpperCase(ch)) return "Uppercase Letter"; 
        else if(Character.isLowerCase(ch)) return "Lowercase Letter"; 
        else if(Character.isDigit(ch)) return "Digit"; 
        else return "Special Character"; 
    } 

    public static char toggleCase(char ch) { 
        if(Character.isUpperCase(ch)) 
            return (char)(ch + 32); 
        else if(Character.isLowerCase(ch)) 
            return (char)(ch - 32); 
        else 
            return ch; 
    } 

    public static String caesarCipher(String text, int shift) { 
        StringBuilder result = new StringBuilder(); 
        for(char c : text.toCharArray()){ 
            if(Character.isUpperCase(c)){ 
                char ch = (char)(((c - 'A' + shift) % 26) + 'A'); 
                result.append(ch); 
            } 
            else if(Character.isLowerCase(c)){ 
                char ch = (char)(((c - 'a' + shift) % 26) + 'a'); 
                result.append(ch); 
            } 
            else{ 
                result.append(c); 
            } 
        } 
        return result.toString(); 
    } 

    public static void displayASCIITable(int start, int end) { 
        for(int i=start; i<=end; i++){ 
            System.out.println(i+" -> "+(char)i); 
        } 
    } 

    public static int[] stringToASCII(String text) { 
        int[] asciiValues = new int[text.length()]; 
        for(int i=0;i<text.length();i++){ 
            asciiValues[i] = (int)text.charAt(i); 
        } 
        return asciiValues; 
    } 

    public static String asciiToString(int[] asciiValues) { 
        StringBuilder sb = new StringBuilder(); 
        for(int val: asciiValues){ 
            sb.append((char)val); 
        } 
        return sb.toString(); 
    } 
} 
