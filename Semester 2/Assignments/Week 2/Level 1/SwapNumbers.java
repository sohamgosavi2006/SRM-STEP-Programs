
import java.util.*;

public class SwapNumbers {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        // Swapping of Numbers with Two Variables
        number1 = number1 + number2;
        number2 = number1 - number2;
        number1 = number1 - number2;

        System.out.println("The swapped numbers are " + number1 + "and" + number2);

    }
}
