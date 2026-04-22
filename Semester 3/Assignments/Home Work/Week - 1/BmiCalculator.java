import java.util.Scanner;

public class BmiCalculator {

    private static String getStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    private static String[] computeSingle(double weight, double height) {
        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);
        String status = getStatus(bmi);
        return new String[] {
            String.valueOf(height),
            String.valueOf(weight),
            String.format("%.2f", bmi),
            status
        };
    }

    private static String[][] computeAll(double[][] personData) {
        String[][] results = new String[10][4];
        for (int i = 0; i < 10; i++) {
            results[i] = computeSingle(personData[i][0], personData[i][1]);
        }
        return results;
    }

    private static void displayResults(String[][] results) {
        System.out.println("Height\tWeight\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.println(results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + results[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            personData[i][1] = scanner.nextDouble();
        }
        String[][] results = computeAll(personData);
        displayResults(results);
    }
}