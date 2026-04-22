
import java.util.*;

public class ZaraBonus {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Salary");
        double salary = sc.nextDouble();

        System.out.println("Enter Your Year Of Service");
        int yearOfService = sc.nextInt();

        double bonus ;

        if (yearOfService > 5) {
            // use decimal 0.05 , (5/100) would lead to output in integer
            bonus =  salary * 0.05; 
        }else {
            bonus = 0;
        }

        System.out.println("Bonus Amount = " + bonus);

    }
}
