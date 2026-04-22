import java.util.*;
 
public class SumNumbers1
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       double total =0.0;
       boolean run=true;

       int number;

       while(run){
            System.out.println("Enter a Real Number");
            number=sc.nextInt();

            if(number==0)
                run=false;

            total += number;

       }

       System.out.println("Total Value = "+total);
 
    }
}