import java.util.Scanner;

class BMICalculator {
    public static String[][] calculateBMIStatus(double[][] measurements) {
        String[][] results = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double weight = measurements[i][0];
            double height = measurements[i][1] / 100;
            double bmi = weight / (height * height);
            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            results[i][0] = String.format("%.2f", measurements[i][1]);
            results[i][1] = String.format("%.2f", weight);
            results[i][2] = String.format("%.2f", bmi);
            results[i][3] = status;
        }
        return results;
    }

    public static String[][] processTeamBMI(double[][] measurements) {
        return calculateBMIStatus(measurements);
    }

    public static void displayResults(String[][] results) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "\t\t" + results[i][1] + "\t\t" + results[i][2] + "\t" + results[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] measurements = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            measurements[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            measurements[i][1] = sc.nextDouble();
        }
        String[][] results = processTeamBMI(measurements);
        displayResults(results);
        sc.close();
    }
}