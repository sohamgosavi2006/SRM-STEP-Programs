import java.util.Scanner;

public class NaturalNumberSum {
    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            return;
        }
        
        int sumRecursive = recursiveSum(n);
        int sumFormula = formulaSum(n);
        
        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula: " + sumFormula);
        
        if (sumRecursive == sumFormula) {
            System.out.println("Both results match. Computation is correct!");
        } else {
            System.out.println("There is a discrepancy in the results.");
        }
    }
}
