package src;

/**
 * ============================================================
 * MAIN CLASS - UseCase1PalindromeApp
 * ============================================================
 *
 * Use Case 1: Application Entry & Welcome Message
 *
 * Description:
 * This class represents the entry point of the
 * Palindrome Checker Management System.
 *
 * At this stage, the application:
 * - Starts execution from the main() method
 * - Displays a welcome message
 * - Shows application version
 *
 * No palindrome logic is implemented yet.
 *
 * The goal is to establish a clear startup flow.
 *
 * @author Soham
 * @version 1.0
 */

import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String Args[]){

        System.out.println("Enter a Number");
        Scanner sc = new Scanner(System.in);

        int num;
        num=sc.nextInt();

        int checkNum=num;
        int palindrome=0;

        while(num!=0){
            int temp=num%10;

            palindrome=palindrome*10;
            palindrome+=temp;

            num/=10;
        }

        if(checkNum==palindrome){
            System.out.println("Number is Palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }

    }
}