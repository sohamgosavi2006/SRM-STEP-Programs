import java.util.*;
 
public class FactorialNumber1
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

       while(number!=0){
            factorial *=number;
            number--;
       }

       System.out.println("Factorial Of The Number is = " +factorial);
 
    }
}