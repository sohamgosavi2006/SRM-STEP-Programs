
import java.util.*;

public class NumberType {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numbers[] = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();

            if (numbers[i] < 0) {
                System.out.println("The Number is Negative");
            } else if (numbers[i] == 0) {
                System.out.println("The Number is Zero");
            } else {
                System.out.println("The Number is Positive");
                if (numbers[i] % 2 == 0) {
                    System.out.println("Number is Even");
                } else {
                    System.out.println("Number is Odd");

                }
            }
        }

        if (numbers[0] < numbers[numbers.length - 1]) {
            System.out.println("Last Element Number is Larger Than First Element");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First Element Number is Larger Than Last Element");
        } else {
            System.out.println("Both numbers are Equal");
        }

    }
}
