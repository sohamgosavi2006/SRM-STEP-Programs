
import java.util.*;

public class ArmstrongNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number");

        int number = sc.nextInt();

        int sum = 0;
        int armstrongNumber = number;

        while (number != 0) {
            sum += Math.pow(number % 10, 3);
            number /= 10;
        }

        if (armstrongNumber == sum) {
            System.out.println(number + " is an Armstrong Number");
        }
        else {
            System.out.println(number + " is NOT an Armstrong Number");
        }

    }
}
