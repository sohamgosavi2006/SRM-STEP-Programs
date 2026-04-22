import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Reservation entity
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

// Inventory Service
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, -1);
    }

    public boolean hasRoomType(String type) {
        return inventory.containsKey(type);
    }

    public void reduceRoom(String type, int count) throws InvalidBookingException {
        int available = getAvailability(type);

        if (available < count) {
            throw new InvalidBookingException("Not enough rooms available for " + type);
        }

        inventory.put(type, available - count);
    }

    public void displayInventory() {
        System.out.println("\nInventory:");
        for (String key : inventory.keySet()) {
            System.out.println(key + " : " + inventory.get(key));
        }
    }
}

// Validator (core UC9)
class BookingValidator {

    public void validate(Reservation r, RoomInventory inventory)
            throws InvalidBookingException {

        // Validate room type
        if (!inventory.hasRoomType(r.getRoomType())) {
            throw new InvalidBookingException("Invalid room type: " + r.getRoomType());
        }

        // Validate request count
        if (r.getRoomsRequested() <= 0) {
            throw new InvalidBookingException("Rooms requested must be greater than 0");
        }

        // Validate availability
        if (inventory.getAvailability(r.getRoomType()) < r.getRoomsRequested()) {
            throw new InvalidBookingException("Insufficient rooms for " + r.getRoomType());
        }
    }
}

// Booking Service with validation
class BookingService {

    private BookingValidator validator = new BookingValidator();

    public void processBooking(Reservation r, RoomInventory inventory) {

        try {
            // Fail-fast validation
            validator.validate(r, inventory);

            // If valid → proceed
            inventory.reduceRoom(r.getRoomType(), r.getRoomsRequested());

            System.out.println("Booking CONFIRMED for " + r.getGuestName());

        } catch (InvalidBookingException e) {
            // Graceful failure
            System.out.println("Booking FAILED for " + r.getGuestName()
                    + " -> " + e.getMessage());
        }
    }
}

// Main class
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 2);
        inventory.addRoomType("Double", 1);

        BookingService service = new BookingService();

        // Test cases
        Reservation r1 = new Reservation("Alice", "Single", 1);   // valid
        Reservation r2 = new Reservation("Bob", "Suite", 1);      // invalid room type
        Reservation r3 = new Reservation("Charlie", "Double", 5); // insufficient
        Reservation r4 = new Reservation("David", "Single", 0);   // invalid count

        service.processBooking(r1, inventory);
        service.processBooking(r2, inventory);
        service.processBooking(r3, inventory);  
        service.processBooking(r4, inventory);

        // Final inventory check
        inventory.displayInventory();
    }
}