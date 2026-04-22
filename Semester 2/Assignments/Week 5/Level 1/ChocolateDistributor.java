import java.util.Scanner;

public class ChocolateDistributor {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        
        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();
        
        if (numberOfChildren == 0) {
            System.out.println("Cannot divide chocolates among zero children!");
        } else {
            int[] res = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
            System.out.println("Each child gets: " + res[0] + " chocolates");
            System.out.println("Remaining chocolates: " + res[1]);
        }
        
        sc.close();
    }
}
