public class GCD {

    // Method to compute the GCD using Euclidean Algorithm
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;  // checking remainder
            a = temp;
        }
        return a;  // The GCD is stored in a
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 98;
        
        // Calling the findGCD method
        int gcd = findGCD(num1, num2);
        
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }
}
