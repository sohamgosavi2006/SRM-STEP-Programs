
import java.util.*;

public class SpringSeason {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Month and Day as Number respectively");
        int month = sc.nextInt();
        int day = sc.nextInt();

        if ((month == 4 && month == 5) || (month == 3 && day >= 20) || (month == 6 && day <= 20)) {
            System.out.println("Its a Spring Season"); 
        }else {
            System.out.println("Not a Spring Season");
        }

    }
}
