
import java.util.*;

public class Calculator {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Two Numbers ");

        int first = sc.nextInt(), second = sc.nextInt();

        double result=0.0;

        System.out.println("Enter Operation");

        String operation = sc.next();

        switch (operation) {
            case "+": result=first+second;
                break;
            case "-" : result=first+second;
                break;
            case "/" : result=first/second;
                break;
            case "*" : result=first*second;
                break;
                default: System.out.println("Invalid Operator");
        }

        System.out.println("Result = "+result);

 
    }
}