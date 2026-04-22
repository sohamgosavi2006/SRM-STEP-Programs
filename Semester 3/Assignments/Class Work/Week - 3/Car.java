import java.util.*;

public class Car {
    String brand, model, color;
    int year;
    boolean isRunning;

    public Car(String b, String m, String c, int y, boolean iR) {
        brand = b;
        model = m;
        color = c;
        year = y;
        isRunning = iR;
    }

    void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + ": Engine started.");
    }

    void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + ": Engine stopped.");
    }

    void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("Is Running: " + isRunning);
        System.out.println();
    }

    int getAge(int currentYear) {
        return currentYear - year;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car car1 = new Car("Mercedes", "C-Class", "Black", 2017, false);
        Car car2 = new Car("Toyota", "Camry", "White", 2019, false);
        Car car3 = new Car("Tesla", "Model 3", "Red", 2022, false);

        System.out.println("Enter Current Year:");
        int currentYear = sc.nextInt();

        car1.startEngine();
        car1.displayInfo();
        car1.stopEngine();
        System.out.println("Age of " + car1.brand + ": " + car1.getAge(currentYear));
        System.out.println();

        car2.startEngine();
        car2.displayInfo();
        car2.stopEngine();
        System.out.println("Age of " + car2.brand + ": " + car2.getAge(currentYear));
        System.out.println();

        car3.startEngine();
        car3.displayInfo();
        car3.stopEngine();
        System.out.println("Age of " + car3.brand + ": " + car3.getAge(currentYear));
        System.out.println();

        sc.close();
    }
}
