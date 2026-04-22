import java.util.*;
 
public class SumNumbers2
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       double total =0.0;
       int number;

       while(true){
            System.out.println("Enter a Real Number");
            number=sc.nextInt();

            if(number==0)
                break; // to exit while loop

            total += number;

       }

       System.out.println("Total Value = "+total);
 
    }
}