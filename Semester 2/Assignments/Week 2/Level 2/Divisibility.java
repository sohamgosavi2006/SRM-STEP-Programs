import java.util.*;
 
public class Divisibility
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter a Number");

       int number = sc.nextInt();
       boolean divisible = false;

       if(number%5==0){
        divisible=true;
       }

       System.out.println("Is the number "+number+" divisible by 5? " +divisible);
 
    }
}