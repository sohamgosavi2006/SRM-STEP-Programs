import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add room type
    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    // Get availability
    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    // Update availability
    public void updateAvailability(String type, int change) {
        int current = inventory.getOrDefault(type, 0);
        int updated = current + change;

        if (updated < 0) {
            System.out.println("Invalid update: Not enough rooms for " + type);
            return;
        }

        inventory.put(type, updated);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("\nRoom Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class UC3 {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        // Initialize rooms
        inventory.addRoomType("Single", 10);
        inventory.addRoomType("Double", 5);
        inventory.addRoomType("Suite", 2);

        inventory.displayInventory();

        // Booking
        System.out.println("\nBooking 3 Single rooms...");
        inventory.updateAvailability("Single", -3);

        // Cancellation
        System.out.println("Cancelling 1 Double room...");
        inventory.updateAvailability("Double", 1);

        // Invalid case
        System.out.println("Trying invalid booking...");
        inventory.updateAvailability("Suite", -5);

        inventory.displayInventory();

        // Check availability
        System.out.println("\nAvailable Single rooms: "
                + inventory.getAvailability("Single"));
    }
}