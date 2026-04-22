import java.util.Scanner;

public class SimpleInterest {

    static Scanner sc = new Scanner(System.in);
    
    // Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
    
    public static void main(String[] args) {
        double principal, rate, time, simpleInterest;
        
        System.out.print("Enter the Principal amount: ");
        principal = sc.nextDouble();
        
        System.out.print("Enter the Rate of Interest: ");
        rate = sc.nextDouble();
        
        System.out.print("Enter the Time period: ");
        time = sc.nextDouble();
        
        // Calculate simple interest
        simpleInterest = calculateSimpleInterest(principal, rate, time);
        
        System.out.println("The Simple Interest is " + simpleInterest + 
                          " for Principal " + principal + 
                          ", Rate of Interest " + rate + 
                          " and Time " + time);
        
        
    }
}