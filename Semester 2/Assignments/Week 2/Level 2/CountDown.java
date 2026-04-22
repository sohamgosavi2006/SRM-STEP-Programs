
import java.util.*;

public class CountDown {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Countdown Value");

        int counter = sc.nextInt();

        for (int i=counter ; i >= 1; i--) {
            System.out.println(i);
        }

    }
}
