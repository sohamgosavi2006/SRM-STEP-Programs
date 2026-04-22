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
    private Set<String> bogieIds; // UC3: HashSet to enforce unique IDs

    public Train(String engineId) {
        this.engineId = engineId;
        this.bogies = new ArrayList<>();
        this.bogieIds = new HashSet<>();
    }

    // UC3: Updated to prevent duplicate bogie IDs
    public void addBogie(Bogie bogie) {
        if (bogieIds.add(bogie.getId())) {
            bogies.add(bogie);
            System.out.println("Successfully added Bogie: " + bogie.getId());
        } else {
            System.err.println("CRITICAL ERROR: Duplicate Bogie ID detected! [" + bogie.getId() + "] Registration rejected.");
        }
    }

    // UC3: Updated to maintain set synchrony
    public boolean removeBogie(String bogieId) {
        Iterator<Bogie> iterator = bogies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(bogieId)) {
                iterator.remove();
                bogieIds.remove(bogieId); // Keep the set in sync
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
        System.out.println("--- Train Consist Management App (UC3: Unique Bogie IDs) ---");

        // 1. Initialize Train
        Train train = new Train("Bharat-Gati-123");

        // 2. Add Unique Bogies
        train.addBogie(new PassengerBogie("P-SL1", "Sleeper", 72, 60));
        train.addBogie(new PassengerBogie("P-AC1", "AC Chair Car", 60, 40));
        
        // 3. UC3: Demonstrate Duplicate ID Prevention
        System.out.println("\nAttempting to add duplicate Bogie ID: P-SL1...");
        train.addBogie(new PassengerBogie("P-SL1", "Sleeper", 72, 0)); // Same ID but different instance

        // 4. Add more unique bogies
        train.addBogie(new GoodsBogie("G-COAL1", "Open Wagon", "Coal", true));

        // 5. Display Summary to verify count
        train.displayConsistSummary();

        // 6. Demonstrate Removal and Re-addition
        String removeId = "P-AC1";
        System.out.println("Removing " + removeId + " to test re-addition...");
        train.removeBogie(removeId);

        System.out.println("\nRe-adding " + removeId + "...");
        train.addBogie(new PassengerBogie("P-AC1", "AC Chair Car", 60, 0));

        // Final State
        train.displayConsistSummary();
    }
}