import java.util.Scanner;

public class DivisionCalculator {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int num = sc.nextInt();
        
        System.out.print("Enter the second number: ");
        int div = sc.nextInt();
        
        if (div == 0) {
            System.out.println("Cannot divide by zero!");
        } else {
            int[] res = findRemainderAndQuotient(num, div);
            System.out.println("Quotient = " + res[0]);
            System.out.println("Remainder = " + res[1]);
        }
        
        sc.close();
    }
}
