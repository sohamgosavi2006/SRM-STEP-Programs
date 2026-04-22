
import java.util.*;

public class BMI2 {

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of persons ");
        int numPersons = sc.nextInt();

        double data[][] = new double[numPersons][3];
        String[] weightCategory = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter height of person in m " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter weight of person in kg " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        for (int i = 0; i < numPersons; i++) {
            data[i][2] = data[i][1] / (data[i][0] * data[i][0]);

            if (data[i][2] <= 18.4) {
                weightCategory[i] = "Underweight";
            } else if (data[i][2] <= 24.9) {
                weightCategory[i] = "Normal weight";
            } else if (data[i][2] <= 39.9) {
                weightCategory[i] = "Overweight";
            } else {
                weightCategory[i] = "Obese";
            }
        }

        System.out.println("\nPerson Details:");
        System.out.println("Height(m)  Weight(kg)  BMI  Weight Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.println(data[i][0] + " " + data[i][1] + " " + data[i][2] + " " + weightCategory[i]);
        }
    }
}
