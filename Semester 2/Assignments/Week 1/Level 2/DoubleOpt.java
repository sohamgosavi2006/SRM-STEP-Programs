import java.util.*;

public class DoubleOpt
{
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        double a,b,c;

        System.out.println("Enter Three Double Numbers");

        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();

        double result;

        result = a + b *c;

        System.out.print("The results of Int Operations are "+result);

        result = a * b + c;

        System.out.print(", "+result);

        result = c + a / b;

        System.out.print(", "+result);

        result=a % b + c;

        System.out.print(" and "+result);
    }
}