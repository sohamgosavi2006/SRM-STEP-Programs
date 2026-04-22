
import java.util.*;

public class MultiplicationTable {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number");

        int number = sc.nextInt();

        System.out.println("Multiplication Table of "+ number);

        for (int i = 6; i <= 9; i++) {
            System.out.println(number+"*"+i+"= "+number*i);
        }
    }
}
