import java.util.*;

public class QuotientRemainder
{
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        float number1,number2;

        System.out.println("Enter Two Numbers");

        number1=sc.nextFloat();
        number2=sc.nextFloat();

        float quotient,remainder;

        quotient=number1/number2;
        remainder=number1%number2;

        System.out.println("The Quotient is "+quotient+"and Reminder is "
        +remainder+" of two number "+number1+" and "+number2);
    }
}