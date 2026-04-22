import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] bmiData = new double[10][3]; // 10 rows, 3 columns (weight, height, BMI)
        String[] bmiStatus = new String[10];

        // Taking user input for weight and height
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            bmiData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            bmiData[i][1] = scanner.nextDouble();

            // Calculate BMI and store it in the array
            bmiData[i][2] = calculateBMI(bmiData[i][0], bmiData[i][1]);

            // Determine BMI status
            bmiStatus[i] = getBMIStatus(bmiData[i][2]);
        }
        scanner.close();

        // Display results
        System.out.println("\nHeight (cm) | Weight (kg) | BMI  | Status");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f cm  | %.2f kg  | %.2f  | %s\n", bmiData[i][1], bmiData[i][0], bmiData[i][2], bmiStatus[i]);
        }
    }

    // Method to calculate BMI
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100; // Convert height to meters
        return weight / (heightM * heightM);
    }

    // Method to determine BMI status
    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
