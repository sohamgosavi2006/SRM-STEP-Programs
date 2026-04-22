import java.util.Scanner;

public class UnitConvertor {
    private static final double KM_TO_MILES = 0.621371;
    private static final double MILES_TO_KM = 1.60934;
    private static final double METERS_TO_FEET = 3.28084;
    private static final double FEET_TO_METERS = 0.3048;
    private static final double YARDS_TO_FEET = 3;
    private static final double FEET_TO_YARDS = 0.333333;
    private static final double METERS_TO_INCHES = 39.3701;
    private static final double INCHES_TO_METERS = 0.0254;
    private static final double FAHRENHEIT_TO_CELSIUS = 5.0 / 9.0;
    private static final double CELSIUS_TO_FAHRENHEIT = 9.0 / 5.0;
    private static final double POUNDS_TO_KILOGRAMS = 0.453592;
    private static final double KILOGRAMS_TO_POUNDS = 2.20462;
    private static final double GALLONS_TO_LITERS = 3.78541;
    private static final double LITERS_TO_GALLONS = 0.264172;

    public static double convertKmToMiles(double km) {
        return km * KM_TO_MILES;
    }

    public static double convertMilesToKm(double miles) {
        return miles * MILES_TO_KM;
    }

    public static double convertMetersToFeet(double meters) {
        return meters * METERS_TO_FEET;
    }

    public static double convertFeetToMeters(double feet) {
        return feet * FEET_TO_METERS;
    }
    
    public static double convertYardsToFeet(double yards) {
        return yards * YARDS_TO_FEET;
    }
    
    public static double convertFeetToYards(double feet) {
        return feet * FEET_TO_YARDS;
    }
    
    public static double convertMetersToInches(double meters) {
        return meters * METERS_TO_INCHES;
    }
    
    public static double convertInchesToMeters(double inches) {
        return inches * INCHES_TO_METERS;
    }
    
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * FAHRENHEIT_TO_CELSIUS;
    }
    
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * CELSIUS_TO_FAHRENHEIT) + 32;
    }
    
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * POUNDS_TO_KILOGRAMS;
    }
    
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * KILOGRAMS_TO_POUNDS;
    }
    
    public static double convertGallonsToLiters(double gallons) {
        return gallons * GALLONS_TO_LITERS;
    }
    
    public static double convertLitersToGallons(double liters) {
        return liters * LITERS_TO_GALLONS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter distance in kilometers: ");
        double km = scanner.nextDouble();
        System.out.println(km + " km = " + convertKmToMiles(km) + " miles");
        
        System.out.print("Enter distance in miles: ");
        double miles = scanner.nextDouble();
        System.out.println(miles + " miles = " + convertMilesToKm(miles) + " km");
        
        System.out.print("Enter length in meters: ");
        double meters = scanner.nextDouble();
        System.out.println(meters + " meters = " + convertMetersToFeet(meters) + " feet");
        
        System.out.print("Enter length in feet: ");
        double feet = scanner.nextDouble();
        System.out.println(feet + " feet = " + convertFeetToMeters(feet) + " meters");
        
        System.out.print("Enter length in yards: ");
        double yards = scanner.nextDouble();
        System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");
        
        System.out.print("Enter length in feet: ");
        feet = scanner.nextDouble();
        System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");
        
        System.out.print("Enter length in meters: ");
        meters = scanner.nextDouble();
        System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");
        
        System.out.print("Enter length in inches: ");
        double inches = scanner.nextDouble();
        System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");
        
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        System.out.println(fahrenheit + " °F = " + convertFahrenheitToCelsius(fahrenheit) + " °C");
        
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        System.out.println(celsius + " °C = " + convertCelsiusToFahrenheit(celsius) + " °F");
        
        System.out.print("Enter weight in pounds: ");
        double pounds = scanner.nextDouble();
        System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");
        
        System.out.print("Enter weight in kilograms: ");
        double kilograms = scanner.nextDouble();
        System.out.println(kilograms + " kg = " + convertKilogramsToPounds(kilograms) + " lbs");
        
        System.out.print("Enter volume in gallons: ");
        double gallons = scanner.nextDouble();
        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");
        
        System.out.print("Enter volume in liters: ");
        double liters = scanner.nextDouble();
        System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");
    }
}
