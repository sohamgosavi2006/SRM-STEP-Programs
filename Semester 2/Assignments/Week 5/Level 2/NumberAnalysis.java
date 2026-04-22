import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Taking user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        // Processing each number
        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.print(num + " is positive and ");
                if (isEven(num)) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else {
                System.out.println(num + " is negative.");
            }
        }

        // Comparing first and last elements
        int result = compare(numbers[0], numbers[4]);
        System.out.print("\nComparison of first and last elements: ");
        if (result == 1) {
            System.out.println(numbers[0] + " is greater than " + numbers[4]);
        } else if (result == -1) {
            System.out.println(numbers[0] + " is less than " + numbers[4]);
        } else {
            System.out.println(numbers[0] + " is equal to " + numbers[4]);
        }
    }

    // Method to check if a number is positive
    public static boolean isPositive(int num) {
        return num >= 0;
    }

    // Method to check if a number is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 < num2) {
            return -1;
        } else {
            return 0;
        }
    }
}
