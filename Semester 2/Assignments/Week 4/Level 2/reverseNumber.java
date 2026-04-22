import java.util.*;

public class reverseNumber {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number");
        int number = sc.nextInt();

        int temp = number, count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int digits[] = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        // Loop runs till entire length of digits array incrementing in each step
        System.out.print("Reversed Numbers are in the array");
        for (int digit : digits) {
            System.out.print(digit);
        }
        System.out.println("");
    }

}
