import java.util.*;

// Reservation entity (same as UC5)
class Reservation {
    private String guestName;
    private String roomType;
    private int roomsRequested;

    public Reservation(String guestName, String roomType, int roomsRequested) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomsRequested = roomsRequested;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomsRequested() {
        return roomsRequested;
    }
}

// Inventory Service (centralized state)
class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void reduceRoom(String type) {
        int current = inventory.getOrDefault(type, 0);
        if (current > 0) {
            inventory.put(type, current - 1);
        }
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (String key : inventory.keySet()) {
            System.out.println(key + " : " + inventory.get(key));
        }
    }
}

// Booking Request Queue (FIFO)
class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation r) {
        queue.offer(r);
    }

    public Reservation getNextRequest() {
        return queue.poll(); // dequeue FIFO
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

// Booking Service (CORE UC6)
class BookingService {

    // Track all allocated room IDs (global uniqueness)
    private Set<String> allocatedRoomIds = new HashSet<>();

    // Map room type → assigned room IDs
    private Map<String, Set<String>> roomAllocations = new HashMap<>();

    // Generate unique room ID
    private String generateRoomId(String roomType, int number) {
        return roomType.substring(0, 2).toUpperCase() + "-" + number;
    }

    public void processBookings(BookingRequestQueue queue, RoomInventory inventory) {

        int idCounter = 1;

        while (!queue.isEmpty()) {

            Reservation req = queue.getNextRequest();
            String type = req.getRoomType();
            int needed = req.getRoomsRequested();

            System.out.println("\nProcessing request for " + req.getGuestName());

            int available = inventory.getAvailability(type);

            if (available >= needed) {

                for (int i = 0; i < needed; i++) {

                    String roomId;

                    // Ensure uniqueness
                    do {
                        roomId = generateRoomId(type, idCounter++);
                    } while (allocatedRoomIds.contains(roomId));

                    allocatedRoomIds.add(roomId);

                    roomAllocations
                        .computeIfAbsent(type, k -> new HashSet<>())
                        .add(roomId);

                    // Atomic step → update inventory immediately
                    inventory.reduceRoom(type);

                    System.out.println("Allocated Room ID: " + roomId);
                }

                System.out.println("Reservation CONFIRMED for " + req.getGuestName());

            } else {
                System.out.println("Reservation FAILED for " + req.getGuestName()
                        + " (Insufficient rooms)");
            }
        }
    }

    public void displayAllocations() {
        System.out.println("\nRoom Allocations:");
        for (String type : roomAllocations.keySet()) {
            System.out.println(type + " -> " + roomAllocations.get(type));
        }
    }
}

// Main class
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Setup inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 3);
        inventory.addRoomType("Double", 2);

        // Setup queue (UC5)
        BookingRequestQueue queue = new BookingRequestQueue();
        queue.addRequest(new Reservation("Alice", "Single", 2));
        queue.addRequest(new Reservation("Bob", "Single", 2)); // should partially fail
        queue.addRequest(new Reservation("Charlie", "Double", 1));

        // Process bookings
        BookingService service = new BookingService(); 
        service.processBookings(queue, inventory);

        // Show results
        service.displayAllocations();
        inventory.displayInventory();
    }
}