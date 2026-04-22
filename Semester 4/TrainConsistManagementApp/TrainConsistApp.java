import java.util.*;
import java.util.stream.*;

// Base Bogie class
class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " Bogie (Capacity: " + capacity + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 72)
        );

        // Display bogies
        System.out.println("Train Bogies:");
        bogies.forEach(System.out::println);

        // Step 2: Stream pipeline with map() and reduce()
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())   // Extract capacity
                .reduce(0, Integer::sum);    // Aggregate (sum)

        // Step 3: Display result
        System.out.println("\nTotal Seating Capacity: " + totalSeats);
    }
}