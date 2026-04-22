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
    private LinkedList<Bogie> bogies; // UC4: LinkedList to model physical chaining
    private Set<String> bogieIds; // Unique IDs enforced from UC3

    public Train(String engineId) {
        this.engineId = engineId;
        this.bogies = new LinkedList<>(); // UC4: Using LinkedList
        this.bogieIds = new HashSet<>();
    }

    public void addBogie(Bogie bogie) {
        if (bogieIds.add(bogie.getId())) {
            bogies.add(bogie); // Adds to the end of the chain
            System.out.println("Chained Bogie: " + bogie.getId());
        } else {
            System.err.println("Duplicate Bogie ID rejected: [" + bogie.getId() + "]");
        }
    }

    // UC4: Adds a bogie to the front of the train (just behind engine)
    public void addBogieAtFront(Bogie bogie) {
        if (bogieIds.add(bogie.getId())) {
            bogies.addFirst(bogie);
            System.out.println("Chained Bogie at FRONT: " + bogie.getId());
        } else {
            System.err.println("Duplicate Bogie ID rejected: [" + bogie.getId() + "]");
        }
    }

    public boolean removeBogie(String bogieId) {
        Iterator<Bogie> iterator = bogies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(bogieId)) {
                iterator.remove();
                bogieIds.remove(bogieId);
                System.out.println("Unchained Bogie: " + bogieId);
                return true;
            }
        }
        return false;
    }

    public Bogie findBogie(String bogieId) {
        for (Bogie b : bogies) {
            if (b.getId().equals(bogieId)) return b;
        }
        return null;
    }

    public void displayConsistSummary() {
        System.out.println("\n===== TRAIN CHANNELS (LinkedList) =====");
        System.out.println("Locomotive -> " + engineId);
        int count = 1;
        for (Bogie b : bogies) {
            System.out.println("  [" + (count++) + "] " + b.getId() + " (" + b.type + ")");
        }
        System.out.println("Total units in consist: " + count);
        System.out.println("========================================\n");
    }
}

// Main Class
public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("--- Train Consist Management App (UC4: LinkedList Chaining) ---");

        // 1. Initialize Train
        Train train = new Train("GatiShakti-Exp-501");

        // 2. Chaining Bogies in sequence (LinkedList add)
        System.out.println("Building the train consist...");
        train.addBogie(new PassengerBogie("P-SL1", "Sleeper", 72, 60));
        train.addBogie(new PassengerBogie("P-AC1", "AC Chair", 60, 40));
        train.addBogie(new GoodsBogie("G-COAL1", "Wagon", "Coal", true));

        // 3. Demonstrate adding a special bogie at the front (LinkedList addFirst)
        System.out.println("\nUpdating consist: Adding VIP Coach at the front...");
        train.addBogieAtFront(new PassengerBogie("P-VIP1", "Executive", 20, 5));

        // 4. Display ordered consist
        train.displayConsistSummary();

        // 5. Demonstrate removal from chain
        System.out.println("Emergency Operation: Detaching " + "G-COAL1" + "...");
        train.removeBogie("G-COAL1");

        // Final State
        train.displayConsistSummary();
    }
}