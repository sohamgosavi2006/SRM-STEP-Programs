import java.util.*;

// Abstract class for Bogie
abstract class Bogie {
    protected String id;
    protected String type;

    public Bogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public abstract void displayDetails();
}

// Passenger Bogie Class
class PassengerBogie extends Bogie {
    private int capacity;
    private int occupiedSeats;

    public PassengerBogie(String id, String type, int capacity, int occupiedSeats) {
        super(id, type);
        this.capacity = capacity;
        this.occupiedSeats = occupiedSeats;
    }

    @Override
    public void displayDetails() {
        System.out.println("Passenger Bogie ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Capacity: " + capacity);
        System.out.println("Occupied Seats: " + occupiedSeats);
        System.out.println("Available Seats: " + (capacity - occupiedSeats));
        System.out.println("-----------------------------------");
    }
}

// Goods Bogie Class
class GoodsBogie extends Bogie {
    private String cargoType;
    private boolean isSafe;

    public GoodsBogie(String id, String type, String cargoType, boolean isSafe) {
        super(id, type);
        this.cargoType = cargoType;
        this.isSafe = isSafe;
    }

    @Override
    public void displayDetails() {
        System.out.println("Goods Bogie ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Cargo Type: " + cargoType);
        System.out.println("Safety Status: " + (isSafe ? "Safe" : "Unsafe"));
        System.out.println("-----------------------------------");
    }
}

// Train Class
class Train {
    private String engineId;
    private List<Bogie> bogies;

    public Train(String engineId) {
        this.engineId = engineId;
        this.bogies = new ArrayList<>();
    }

    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
    }

    public void displayConsistSummary() {
        System.out.println("\n===== TRAIN CONSIST SUMMARY =====");
        System.out.println("Engine ID: " + engineId);
        System.out.println("Total Bogies: " + bogies.size());
        System.out.println("-----------------------------------");

        for (Bogie b : bogies) {
            b.displayDetails();
        }
    }
}

// Main Class
public class TrainConsistApp {
    public static void main(String[] args) {

        // Initialize Train
        Train train = new Train("ENG-101");

        // Add Passenger Bogies
        train.addBogie(new PassengerBogie("PB1", "Sleeper", 72, 50));
        train.addBogie(new PassengerBogie("PB2", "AC Chair", 60, 45));
        train.addBogie(new PassengerBogie("PB3", "First Class", 30, 20));

        // Add Goods Bogies
        train.addBogie(new GoodsBogie("GB1", "Rectangular", "Coal", true));
        train.addBogie(new GoodsBogie("GB2", "Cylindrical", "Oil", true));

        // Display Summary
        train.displayConsistSummary();
    }
}