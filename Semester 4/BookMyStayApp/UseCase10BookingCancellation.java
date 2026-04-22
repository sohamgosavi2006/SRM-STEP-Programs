import java.util.*;

// Reservation entity
class Reservation {
    private String reservationId;
    private String roomType;
    private List<String> allocatedRooms;

    public Reservation(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.allocatedRooms = new ArrayList<>();
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getRoomType() {
        return roomType;
    }

    public List<String> getAllocatedRooms() {
        return allocatedRooms;
    }

    public void addRoom(String roomId) {
        allocatedRooms.add(roomId);
    }
}

// Inventory Service
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public void incrementRoom(String type) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
    }

    public void displayInventory() {
        System.out.println("\nInventory:");
        for (String key : inventory.keySet()) {
            System.out.println(key + " : " + inventory.get(key));
        }
    }
}

// Booking History (tracks active bookings)
class BookingHistory {
    private Map<String, Reservation> history = new HashMap<>();

    public void addReservation(Reservation r) {
        history.put(r.getReservationId(), r);
    }

    public Reservation getReservation(String id) {
        return history.get(id);
    }

    public void removeReservation(String id) {
        history.remove(id);
    }

    public boolean exists(String id) {
        return history.containsKey(id);
    }
}

// Cancellation Service (CORE UC10)
class CancellationService {

    // Stack for rollback tracking (LIFO)
    private Stack<String> rollbackStack = new Stack<>();

    public void cancelBooking(String reservationId,
                              BookingHistory history,
                              RoomInventory inventory) {

        // Validate existence
        if (!history.exists(reservationId)) {
            System.out.println("Cancellation FAILED: Reservation not found");
            return;
        }

        Reservation r = history.getReservation(reservationId);

        System.out.println("\nCancelling Reservation: " + reservationId);

        // Push allocated rooms to stack (LIFO)
        for (String roomId : r.getAllocatedRooms()) {
            rollbackStack.push(roomId);
        }

        // Rollback process (LIFO)
        while (!rollbackStack.isEmpty()) {
            String releasedRoom = rollbackStack.pop();

            // Restore inventory
            inventory.incrementRoom(r.getRoomType());

            System.out.println("Released Room: " + releasedRoom);
        }

        // Remove booking from history
        history.removeReservation(reservationId);

        System.out.println("Cancellation SUCCESS for " + reservationId);
    }
}

// Main class
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        // Setup inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 1);

        // Setup booking history
        BookingHistory history = new BookingHistory();

        // Simulate confirmed booking (from UC6)
        Reservation r1 = new Reservation("RES-101", "Single");
        r1.addRoom("SI-1");
        r1.addRoom("SI-2");

        history.addReservation(r1);

        // Cancellation service
        CancellationService service = new CancellationService();

        // Perform cancellation
        service.cancelBooking("RES-101", history, inventory);

        // Attempt invalid cancellation
        service.cancelBooking("RES-999", history, inventory);

        // Final inventory
        inventory.displayInventory();
    }
}