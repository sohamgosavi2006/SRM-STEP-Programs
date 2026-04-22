import java.util.*;

// Reservation (simplified confirmed booking model)
class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;
    private int roomsBooked;

    public Reservation(String reservationId, String guestName,
                       String roomType, int roomsBooked) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomsBooked = roomsBooked;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomsBooked() {
        return roomsBooked;
    }

    public void display() {
        System.out.println("ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room: " + roomType +
                " | Count: " + roomsBooked);
    }
}

// Booking History (stores confirmed bookings)
class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed booking
    public void addReservation(Reservation r) {
        history.add(r);
    }

    // Retrieve all bookings (read-only usage)
    public List<Reservation> getAllReservations() {
        return history;
    }

    // Display history
    public void displayHistory() {
        System.out.println("\nBooking History:");
        for (Reservation r : history) {
            r.display();
        }
    }
}

// Reporting Service (separate concern)
class BookingReportService {

    // Generate simple summary report
    public void generateSummary(List<Reservation> reservations) {

        System.out.println("\n--- Booking Summary Report ---");

        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : reservations) {
            roomTypeCount.put(
                r.getRoomType(),
                roomTypeCount.getOrDefault(r.getRoomType(), 0)
                        + r.getRoomsBooked()
            );
        }

        for (String type : roomTypeCount.keySet()) {
            System.out.println(type + " Rooms Booked: "
                    + roomTypeCount.get(type));
        }
    }

    // Total bookings count
    public void totalBookings(List<Reservation> reservations) {
        System.out.println("\nTotal Reservations: " + reservations.size());
    }
}

// Main class
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings (from UC6)
        history.addReservation(new Reservation("RES-101", "Alice", "Single", 2));
        history.addReservation(new Reservation("RES-102", "Bob", "Double", 1));
        history.addReservation(new Reservation("RES-103", "Charlie", "Single", 1));

        // Display history
        history.displayHistory();

        // Generate reports
        BookingReportService reportService = new BookingReportService();

        reportService.totalBookings(history.getAllReservations());
        reportService.generateSummary(history.getAllReservations());
    }
}