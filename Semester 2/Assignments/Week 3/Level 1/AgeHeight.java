
import java.util.Scanner;

public class AgeHeight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter Amar's height ");
        int heightAmar = sc.nextInt();

        System.out.print("Enter Akbar's age ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter Akbar's height ");
        int heightAkbar = sc.nextInt();

        System.out.print("Enter Anthony's age: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter Anthony's height ");
        int heightAnthony = sc.nextInt();

        // Using Ternary Operator and Math.in() function

        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        String youngestFriend = (youngestAge == ageAmar) ? "Amar" : (youngestAge == ageAkbar) ? "Akbar" : "Anthony";

        int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        String tallestFriend = (tallestHeight == heightAmar) ? "Amar" : (tallestHeight == heightAkbar) ? "Akbar" : "Anthony";

        System.out.println("Youngest is " + youngestFriend);
        System.out.println("Tallest is " + tallestFriend);

    }
}
