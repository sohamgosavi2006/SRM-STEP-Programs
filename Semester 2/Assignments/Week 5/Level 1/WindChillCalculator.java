import java.util.Scanner;

public class WindChillCalculator {
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the temperature (°F): ");
        double temperature = sc.nextDouble();
        
        System.out.print("Enter the wind speed (mph): ");
        double windSpeed = sc.nextDouble();
        
        if (windSpeed < 3) {
            System.out.println("Wind speed too low for wind chill calculation.");
        } else {
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.printf("The wind chill temperature is: %.2f°F%n", windChill);
        }
        
        sc.close();
    }
}
