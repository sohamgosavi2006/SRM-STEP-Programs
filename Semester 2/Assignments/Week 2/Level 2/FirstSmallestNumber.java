import java.util.*;
 
public class FirstSmallestNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter 3 Numbers");

       int number1,number2,number3;

        number1=sc.nextInt();
        number2=sc.nextInt();
        number3=sc.nextInt();

        boolean num1Small=false;
 
        if(number1>number2 && number1>number3)
            num1Small=true;

        System.out.println(" Is the first number the smallest? "+num1Small);

    }
}