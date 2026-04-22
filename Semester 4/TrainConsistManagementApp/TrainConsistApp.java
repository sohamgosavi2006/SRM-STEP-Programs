import java.util.*;

// Abstract class for Bogie
abstract class Bogie {
    protected String id;
    protected String type;

    public Bogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
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
        System.out.println("Passenger Bogie [" + id + "] | Type: " + type + " | Capacity: " + capacity + " | Available: " + (capacity - occupiedSeats));
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
        System.out.println("Goods Bogie [" + id + "] | Type: " + type + " | Cargo: " + cargoType + " | Safety: " + (isSafe ? "PASS" : "FAIL"));
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
        System.out.println("Added Bogie: " + bogie.getId());
    }

    // UC2: Remove Bogie by ID
    public boolean removeBogie(String bogieId) {
        Iterator<Bogie> iterator = bogies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(bogieId)) {
                iterator.remove();
                System.out.println("Successfully removed Bogie: " + bogieId);
                return true;
            }
        }
        System.out.println("Error: Bogie " + bogieId + " not found in consist.");
        return false;
    }

    // UC2: Find Bogie by ID
    public Bogie findBogie(String bogieId) {
        for (Bogie b : bogies) {
            if (b.getId().equals(bogieId)) {
                return b;
            }
        }
        return null;
    }

    public void displayConsistSummary() {
        System.out.println("\n===== TRAIN CONSIST SUMMARY =====");
        System.out.println("Engine ID: " + engineId);
        System.out.println("Total Bogies: " + bogies.size());
        System.out.println("-----------------------------------");
        for (Bogie b : bogies) {
            b.displayDetails();
        }
        System.out.println("===================================\n");
    }
}

// Main Class
public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("--- Train Consist Management App (UC2: Dynamic Operations) ---");

        // 1. Initialize Train
        Train train = new Train("VandeBharat-Express");

        // 2. Add Passenger Bogies (ArrayList add operation)
        train.addBogie(new PassengerBogie("P-SL1", "Sleeper", 72, 60));
        train.addBogie(new PassengerBogie("P-AC1", "AC Chair Car", 60, 40));
        train.addBogie(new PassengerBogie("P-FC1", "First Class", 30, 10));

        // 3. Add Goods Bogies
        train.addBogie(new GoodsBogie("G-COAL1", "Open Wagon", "Coal", true));

        // 4. Display Initial Consist
        train.displayConsistSummary();

        // 5. Search for a Bogie (ArrayList search logic)
        String searchId = "P-AC1";
        System.out.println("Searching for Bogie: " + searchId);
        Bogie found = train.findBogie(searchId);
        if (found != null) {
            System.out.print("Found: ");
            found.displayDetails();
        }

        // 6. Remove a Bogie (ArrayList remove operation)
        String removeId = "G-COAL1";
        System.out.println("\nDynamic Operation: Removing Bogie " + removeId);
        train.removeBogie(removeId);

        // 7. Display Final Consist Summary
        System.out.println("\nVerifying updated consist...");
        train.displayConsistSummary();
    }
}