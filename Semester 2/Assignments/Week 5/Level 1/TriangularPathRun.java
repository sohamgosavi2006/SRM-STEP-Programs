import java.util.Scanner;

public class TriangularPathRun {
    public static double calculateRounds(double a, double b, double c, double distance) {
        double perimeter = a + b + c;
        if (perimeter <= 0) {
            return -1;
        }
        return Math.round((distance / perimeter) * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the first side (meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of the second side (meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of the third side (meters): ");
        double side3 = scanner.nextDouble();
        scanner.close();

        double result = calculateRounds(side1, side2, side3, 5000);
        if (result == -1) {
            System.out.println("Invalid input: Sides must be positive values.");
        } else {
            System.out.println("The athlete needs to complete " + result + " rounds to run 5 km.");
        }
    }
}
