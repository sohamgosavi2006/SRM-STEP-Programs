import java.util.Scanner;

public class PoundsToKilo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter weight in pounds: ");
        double pounds = sc.nextDouble();

        double kilograms = pounds / 2.2;
        
        System.out.println(pounds + " pounds is equal to " + kilograms + " kilograms.");
        
    }
}
