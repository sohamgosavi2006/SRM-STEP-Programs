
import java.util.*;

public class MultiplicationTable1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number");
        int number = sc.nextInt();

        int multiplicationData[] = new int[10];

        for (int i = 1, j = 0; i <= 10; i++, j++) {
            multiplicationData[j] = number * i;
            System.out.println(number + "*"+ i + " = " + multiplicationData[j]);
        }

    }
}
