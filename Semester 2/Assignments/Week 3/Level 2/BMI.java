
import java.util.*;

public class BMI {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Weight (in kg) and Height(in cm)");
        double weight = sc.nextDouble();
        double height = sc.nextDouble();

        double heightMeter = height / 100;

        double bmi = weight / (heightMeter * heightMeter);

        if (bmi <= 18.4) {
            System.out.println("Underweight");

        } else if (bmi <= 24.9 && bmi >= 18.5) {
            System.out.println("Normal");
        } else if (bmi <= 39.9 && bmi >= 25) {
            System.out.println("Overweight");

        } else if (bmi >= 40) {
            System.out.println("Obese");

        }

    }
}
