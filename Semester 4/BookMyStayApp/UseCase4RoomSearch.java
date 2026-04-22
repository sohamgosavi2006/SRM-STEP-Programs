import java.util.*;

// Domain Model
class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void displayDetails() {
        System.out.println("Type: " + type +
                " | Price: " + price +
                " | Amenities: " + amenities);
    }
}

// Centralized Inventory (same idea as UC3)
class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    // READ-ONLY access
    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    // Expose keys safely (read-only usage)
    public Set<String> getAllRoomTypes() {
        return inventory.keySet();
    }
}

// Search Service (NO mutation allowed)
class SearchService {

    public void searchAvailableRooms(RoomInventory inventory,
                                     Map<String, Room> roomData) {

        System.out.println("\nAvailable Rooms:\n");

        for (String type : inventory.getAllRoomTypes()) {

            int available = inventory.getAvailability(type);

            // Defensive check → skip unavailable
            if (available > 0 && roomData.containsKey(type)) {

                Room room = roomData.get(type);

                room.displayDetails();
                System.out.println("Available Count: " + available);
                System.out.println("------------------------");
            }
        }
    }
}

// Main class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Setup inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 0); // should be filtered out
        inventory.addRoomType("Suite", 2);

        // Setup room domain data
        Map<String, Room> roomData = new HashMap<>();
        roomData.put("Single", new Room("Single", 2000, "WiFi, TV"));
        roomData.put("Double", new Room("Double", 3500, "WiFi, TV, AC"));
        roomData.put("Suite", new Room("Suite", 6000, "WiFi, TV, AC, Mini Bar"));

        // Perform search (READ-ONLY)
        SearchService searchService = new SearchService();
        searchService.searchAvailableRooms(inventory, roomData);

        // Verify inventory unchanged
        System.out.println("\nCheck inventory remains unchanged:");
        System.out.println("Single rooms: " + inventory.getAvailability("Single"));
        System.out.println("Double rooms: " + inventory.getAvailability("Double"));
        System.out.println("Suite rooms: " + inventory.getAvailability("Suite"));
    }
}