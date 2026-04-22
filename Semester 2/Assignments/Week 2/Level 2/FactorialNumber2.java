import java.util.*;
 
public class FactorialNumber2
{
    public static void main(String args[])
    {
        
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter A Positive Number ");
       int number = sc.nextInt();

       if(number<0){
        System.out.println("Entered Number is Negative");
        System.exit(0);
       }

       int factorial=1;

       for(int i=number;i>0;i--){
        factorial *= i;
       }

       System.out.println("Factorial Of The Number is = " +factorial);
 
    }
}