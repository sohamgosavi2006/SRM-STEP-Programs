import java.util.*;
 

// A Harshad number is an integer which
//  is divisible by the sum of its digits. 
// For example, 21 which is perfectly divided by 3 (sum of digits: 2 + 1).

public class HarshadNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter a Number");

        int number = sc.nextInt();

        int sum=0;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        if(number%3==0){
            System.out.println("Harshad Number");
        }
        else{
            System.out.println("NOT Harshad Number");
        }
 
    }
}