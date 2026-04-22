import java.util.*;

// Add-On Service entity
class AddOnService {
    private String name;
    private double cost;

    public AddOnService(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void display() {
        System.out.println(name + " : " + cost);
    }
}

// Add-On Service Manager
class AddOnServiceManager {

    // reservationId -> list of services
    private Map<String, List<AddOnService>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {
        serviceMap
            .computeIfAbsent(reservationId, k -> new ArrayList<>())
            .add(service);

        System.out.println("Added " + service.getName() +
                " to Reservation " + reservationId);
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {
        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services for " + reservationId);
            return;
        }

        System.out.println("\nServices for Reservation " + reservationId + ":");
        for (AddOnService s : services) {
            s.display();
        }
    }

    // Calculate total add-on cost
    public double calculateTotalCost(String reservationId) {
        List<AddOnService> services = serviceMap.get(reservationId);

        double total = 0;
        if (services != null) {
            for (AddOnService s : services) {
                total += s.getCost();
            }
        }
        return total;
    }
}

// Main class
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        // Assume reservation IDs from UC6
        String res1 = "RES-101";
        String res2 = "RES-102";

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1500);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 800);

        // Add services to reservations
        manager.addService(res1, breakfast);
        manager.addService(res1, spa);

        manager.addService(res2, airportPickup);

        // Display services
        manager.displayServices(res1);
        manager.displayServices(res2);

        // Calculate cost
        System.out.println("\nTotal Add-On Cost for " + res1 + " : "
                + manager.calculateTotalCost(res1));

        System.out.println("Total Add-On Cost for " + res2 + " : "
                + manager.calculateTotalCost(res2));
    }
}