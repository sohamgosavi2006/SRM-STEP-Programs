import java.util.*;

public class IntOperation
{
    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        int a,b,c;

        System.out.println("Enter Three Integer Numbers");

        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();

        int result;

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