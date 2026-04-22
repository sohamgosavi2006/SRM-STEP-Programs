
import java.util.*;

public class FizzBuzz2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number");

        int number = sc.nextInt();

        if (number >= 0) {
            int c = 0;
            while (c != (number + 1)) {
                if (c % 3 == 0 && c % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (c % 3 == 0) {
                    System.out.println("Fizz");
                } else if (c % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(number);
                }
                c++;
            }
        }

    }
}
