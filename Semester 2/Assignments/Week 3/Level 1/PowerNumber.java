import java.util.*;
 
public class PowerNumber
{
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
 
       System.out.println("Enter a Number And Power");

        int number = sc.nextInt();
        int power = sc.nextInt();

        int result=1;

        for(int i=1;i<=power;i++){
            result *= number;
        }

        System.out.println("Power of The Number is = "+result);
 
    }
}