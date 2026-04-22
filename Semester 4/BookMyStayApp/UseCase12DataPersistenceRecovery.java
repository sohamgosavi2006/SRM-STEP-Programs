import java.io.*;
import java.util.*;

// Reservation (Serializable)
class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reservationId;
    private String roomType;
    private int roomsBooked;

    public Reservation(String reservationId, String roomType, int roomsBooked) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.roomsBooked = roomsBooked;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomsBooked() {
        return roomsBooked;
    }

    public void display() {
        System.out.println("ID: " + reservationId +
                " | Room: " + roomType +
                " | Count: " + roomsBooked);
    }
}

// Inventory (Serializable)
class RoomInventory implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public void displayInventory() {
        System.out.println("\nInventory:");
        for (String key : inventory.keySet()) {
            System.out.println(key + " : " + inventory.get(key));
        }
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}

// Booking History (Serializable)
class BookingHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getHistory() {
        return history;
    }

    public void displayHistory() {
        System.out.println("\nBooking History:");
        for (Reservation r : history) {
            r.display();
        }
    }
}

// Persistence Service (CORE UC12)
class PersistenceService {

    private static final String FILE_NAME = "hotel_data.ser";

    // Save system state
    public void save(RoomInventory inventory, BookingHistory history) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            oos.writeObject(history);

            System.out.println("\nData successfully saved!");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load system state
    public Object[] load() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            RoomInventory inventory = (RoomInventory) ois.readObject();
            BookingHistory history = (BookingHistory) ois.readObject();

            System.out.println("\nData successfully loaded!");

            return new Object[]{inventory, history};

        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return null;
    }
}

// Main class
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        PersistenceService service = new PersistenceService();

        RoomInventory inventory;
        BookingHistory history;

        // Try loading previous state
        Object[] data = service.load();

        if (data != null) {
            inventory = (RoomInventory) data[0];
            history = (BookingHistory) data[1];
        } else {
            // Initialize fresh state
            inventory = new RoomInventory();
            history = new BookingHistory();

            inventory.addRoomType("Single", 5);
            inventory.addRoomType("Double", 3);

            history.addReservation(new Reservation("RES-101", "Single", 2));
            history.addReservation(new Reservation("RES-102", "Double", 1));
        }

        // Display current state
        inventory.displayInventory();
        history.displayHistory();

        // Save state before exit
        service.save(inventory, history);
    }
}