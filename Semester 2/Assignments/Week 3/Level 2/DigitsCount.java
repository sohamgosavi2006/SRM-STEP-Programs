
import java.util.*;

public class DigitsCount {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number");

        int number = sc.nextInt();

        int sum = 0;
        int count = 0;

        while (number != 0) {
            count++;
            number /= 10;
        }

        System.out.println("Number of Digits : " + number);

    }
}
