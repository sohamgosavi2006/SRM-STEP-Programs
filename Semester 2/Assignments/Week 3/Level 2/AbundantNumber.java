import java.util.*;
 
// An abundant number is an integer in which the sum of all the divisors of the number is greater 
// than the number itself. 
// For example,
// Divisor of 12: 1, 2, 3, 4, 6
// Sum of divisor: 1 + 2 + 3 + 4 + 6 = 16 > 12

public class AbundantNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter a Number");

        int number = sc.nextInt();

        int sum=0;

        for(int i=1;i<number;i++){
            if(number%i==0)
                sum += i;
        }

        if(sum>number)
            System.out.println("Abundant Number");
        else
            System.out.println("NOT an Abundant Number");
 
    }
}