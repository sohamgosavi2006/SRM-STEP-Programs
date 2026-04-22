
import java.util.*;

public class SumNatural2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First 10 Natural Numbers");

        int naturalNumbers[] = new int[10]; // declaring Array
        double loopNaturalSum = 0.0;

        for (int i = 0; i < naturalNumbers.length; i++) {
            naturalNumbers[i] = sc.nextInt();
            if (naturalNumbers[i] < 1) {
                System.out.println("The number " + naturalNumbers[i] + " is not a natural number");
                i--;
            }
            else{
                loopNaturalSum+=naturalNumbers[i];
            }
        }

        double naturalSum = (naturalNumbers.length * (naturalNumbers.length + 1)) / 2;

        if (loopNaturalSum == naturalSum) {
            System.out.println(
                    "The sum of " + naturalNumbers.length + " natural numbers is " + naturalSum);
        }
    }
}
