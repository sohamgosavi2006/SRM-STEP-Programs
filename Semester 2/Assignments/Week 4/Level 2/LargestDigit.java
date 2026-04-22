
import java.util.*;

public class LargestDigit {

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter A Number");
        int number = sc.nextInt();

        int maxDigit = 10;
        int digits[] = new int[maxDigit];

        int tempNum = number;
        int digitIndex = 0;
        while (tempNum != 0) {
            digits[digitIndex] = tempNum % 10;
            tempNum /= 10;

            if (digitIndex == maxDigit) {
                break;
            }
        }

        int largestDigit1 = 0, largestDigit2 = 0;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > largestDigit1) {
                largestDigit1 = digits[i];
            }
            if (digits[i] > largestDigit2 && largestDigit1 > largestDigit2) {
                largestDigit2 = digits[i];
            }
        }

        System.out.println("Largest Digit = " + largestDigit1);
        System.out.println("Second Largest Digit = " + largestDigit2);

    }
}
