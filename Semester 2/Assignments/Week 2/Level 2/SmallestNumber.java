import java.util.*;
 
public class SmallestNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       int number1,number2,number3;

        System.out.println("Enter 3 Numbers");

        number1=sc.nextInt();
        number2=sc.nextInt();
        number3=sc.nextInt();

       boolean num1Large=false,num2Large=false,num3Large=false;

        if(number1>number2 && number1>number3)
            num1Large=true;
        else if(number2>number1 && number2>number3)
            num2Large=true;
        else if(number3>number1 && number3>number2)
            num3Large=true;

        System.out.println("Is the first number the largest? "+num1Large +
                            "Is the second number the largest?"+num2Large+  
                            "Is the third number the largest? "+num3Large);
 
    }
}