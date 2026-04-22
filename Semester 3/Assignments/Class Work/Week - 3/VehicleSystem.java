 class Vehicle { 
// Create protected instance variables (can be accessed in Child Class Only) 

    protected String make,model;
    protected int year;
    protected double fuelLevel;

    // Constructor (common for all vehicles)
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }


// TODO: Create common methods: 
    void startVehicle() {
         System.out.println(year + " " + make + " " + model + " started.");
    }
    void stopVehicle() {
        System.out.println(year + " " + make + " " + model + " stopped.");
    }
    void refuel(double amount) {
        if (amount <= 0) 
            throw new IllegalArgumentException("Refuel amount must be positive");
        fuelLevel += amount;
        System.out.println(model + " refueled by " + amount + "L | Fuel now: " + fuelLevel + "L");
    }
    void displayVehicleInfo() {
        System.out.println("Vehicle: " + year + " " + make + " " + model + " | Fuel: " + fuelLevel + "L");
    }
} 

class Car extends Vehicle{
    private int doors;

    public Car(String make, String model, int year, double fuelLevel, int doors) {
        super(make, model, year, fuelLevel);
        this.doors = doors;
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String make, String model, int year, double fuelLevel, double loadCapacity) {
        super(make, model, year, fuelLevel);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Type: Truck | Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, double fuelLevel, boolean hasSidecar) {
        super(make, model, year, fuelLevel);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Type: Motorcycle | Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

public class VehicleSystem{
    public static void main(String[] args) { 

        // Create different types of vehicles (Car, Truck, Motorcycle) for Polymorphism
        Vehicle v1 = new Car("Mercedes" , "XYZ" ,2015,20,4);
        Vehicle v2 = new Truck("Tata", "Prima", 2018, 120, 15);
        Vehicle v3 = new Motorcycle("Royal Enfield", "Classic 350", 2022, 15, false);

        // Create an array of Vehicle objects 
        Vehicle vehicleArray[] = {v1,v2,v3};

// TODO: Show how the same Vehicle class can be reused 
// Demonstrate polymorphic behavior : 
// (Same parent class for all child classes) -> Use common methods
        for(Vehicle v : vehicleArray){
            v.startVehicle();
            v.refuel(5);
            v.displayVehicleInfo();
            v.stopVehicle();
        }

// TODO: In comments, explain: 
// - How does this show reusability? 
// Sol. -> Parent class methods are common for all child

//  How could this be extended for new vehicle types?
// Sol. -> Create child class(Car,Truck,Motorcycle) which would extend Vehicle

//  What are the benefits over writing separate classes? 
// Sol. -> To increase reusability of code, avoid redundancy (same code copied
//          in multiple classes), new Vehciles can easily be added by creating
//          new Child Class
    } 
}
