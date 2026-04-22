
import java.util.*;

public class FactorsNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number to find Factors");
        int number = sc.nextInt();

        int maxFactor = 10, index = 0;

        int factors[] = new int[maxFactor];

        for (int i = 1; i <= number; i++) {

            if (number % index == 0) {

                if (index >= maxFactor) {
                    maxFactor *= 2;
                    int tempFactors[] = new int[maxFactor];

                    System.arraycopy(factors, 0, tempFactors, 0, factors.length);

                    factors = tempFactors; // Assign resized array

                }
                factors[index] = i;
                index++;

            }
        }

        System.out.println("Factors of Number : ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + ",");
        }

    }
}
