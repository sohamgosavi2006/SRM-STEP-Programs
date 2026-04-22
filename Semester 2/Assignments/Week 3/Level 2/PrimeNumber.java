
import java.util.*;

public class PrimeNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number");

        int number = sc.nextInt();

        if (number < 2) {
            System.out.println("Number should be greater than 1");
        }

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }

            if (isPrime) {
                System.out.println(number + " is a Prime Number");
            } else {
                System.out.println(number + " is NOT a Prime Number");
            }

        }

    }
}
