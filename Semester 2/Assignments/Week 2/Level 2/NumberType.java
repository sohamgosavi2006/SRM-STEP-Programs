import java.util.*;
 
public class NumberType
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter a Number");

       int number=sc.nextInt();

       if(number>0){
            System.out.println("positive");

       }
       else if (number<0) {
           System.out.println("negative");

       }
       else if (number==0) {
           System.out.println("zero");

       }
 
    }
}