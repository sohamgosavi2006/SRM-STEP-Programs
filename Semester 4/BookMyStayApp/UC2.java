/**
 * Abstract class representing a generic Hotel Room.
 * Enforces encapsulation and provides a template for specific room types.
 */
abstract class Room {
    private String type;
    private int beds;
    private double pricePerNight;

    public Room(String type, int beds, double pricePerNight) {
        this.type = type;
        this.beds = beds;
        this.pricePerNight = pricePerNight;
    }

    // Encapsulated Getters
    public String getType() { return type; }
    public int getBeds() { return beds; }
    public double getPricePerNight() { return pricePerNight; }

    /**
     * Common behavior for all rooms to describe themselves.
     */
    public void displayDetails() {
        System.out.println("Room Type:     " + type + " | Beds: " + beds + " | Price: $" + pricePerNight);
    }
}