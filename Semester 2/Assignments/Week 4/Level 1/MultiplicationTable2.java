
import java.util.*;

public class MultiplicationTable2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number");
        int number = sc.nextInt();

        int multiplicationData[] = new int[10];

        for (int i = 6, j = 0; i <= 9; i++, j++) {
            multiplicationData[j] = number * i;
            System.out.println(number + "*"+ i + " = " + multiplicationData[j]);
        }

    }
}
