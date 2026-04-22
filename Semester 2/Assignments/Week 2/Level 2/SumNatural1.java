
import java.util.*;

public class SumNatural1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First 10 Natural Numbers");

        int naturalNumbers[] = new int[10]; // declaring Array

        int c = 0;

        double loopNaturalSum = 0.0;

        while (c != 9) {
            naturalNumbers[c] = sc.nextInt();

            if (naturalNumbers[c] < 1) {
                System.out.println("The number " + naturalNumbers[c] + " is not a natural number");
                c--;
            } else {
                loopNaturalSum += naturalNumbers[c];
                c++;
            }

        }

        double naturalSum = (naturalNumbers.length * (naturalNumbers.length + 1)) / 2;

        if (loopNaturalSum == naturalSum) {
            System.out.println(
                    "The sum of " + naturalNumbers.length + " natural numbers is " + naturalSum);
        }
    }
}
