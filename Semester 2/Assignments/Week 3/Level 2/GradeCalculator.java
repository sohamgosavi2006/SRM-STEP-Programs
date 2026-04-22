
import java.util.*;

public class GradeCalculator {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Marks in Three Subjects");

        double marks1 = sc.nextDouble(),
                marks2 = sc.nextDouble(),
                marks3 = sc.nextDouble();

        double sum = marks1 + marks2 + marks3;

        System.out.println("Average Marks = " + (marks1 + marks2 + marks3) / 3);

        double percentage = (sum / 300) * 100;

        if (percentage >= 80) {
            System.out.println("Grade A");
            System.out.println("Nevel Four, Above Agency Normal Standards");
        } else if (percentage >= 70 && percentage < 80) {
            System.out.println("Grade B");
            System.out.println("Nevel Three, at Agency Normal Standards");

        } else if (percentage >= 60 && percentage < 70) {
            System.out.println("Grade C");
            System.out.println("Nevel Two, below but approaching Agency Normal Standards");

        } else if (percentage >= 50 && percentage < 60) {
            System.out.println("Grade D");
            System.out.println("Nevel One, well Below Agency Normal Standards");

        } else if (percentage >= 40 && percentage < 50) {
            System.out.println("Grade E");
             System.out.println("Nevel One, too Below Agency Normal Standards");
            
           } else {
            System.out.println("Grade R");
            System.out.println("Remedial Student");


        }

    }
}
