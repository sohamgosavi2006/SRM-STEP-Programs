package src;

public class PalindromeStringReverse {

    public static void main(String Args[]){

        String str = "madam";
        String revString = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            revString += ch;
        }


        if (str.equals(revString)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is not Palindrome");
        }
}
}