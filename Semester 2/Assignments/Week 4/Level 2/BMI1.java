
import java.util.*;

public class BMI1 {

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = sc.nextInt();

        double height[] = new double[numPersons];
        double weight[] = new double[numPersons];
        double bmi[] = new double[numPersons];
        String weightStatus[] = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter height for person in m " + (i + 1) );
            height[i] = sc.nextDouble();
            System.out.print("Enter weight for person in kg " + (i + 1));
            weight[i] = sc.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                weightStatus[i] = "Underweight"; 
            }else if (bmi[i] < 24.9) {
                weightStatus[i] = "Normal weight"; 
            }else if (bmi[i] < 29.9) {
                weightStatus[i] = "Overweight"; 
            }else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson Details:");
        // To arrange my table in systematic order
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(m)", "Weight(kg)", "BMI", "Weight Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", height[i], weight[i], bmi[i], weightStatus[i]);
        }
    }
}
