import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementSystem {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String toString() {
            return "Bogie: " + name + ", Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("==================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper PB101", 72));
        bogies.add(new Bogie("AC Chair PB102", 60));
        bogies.add(new Bogie("First Class PB103", 40));
        bogies.add(new Bogie("Sleeper PB104", 68));

        System.out.println("All Passenger Bogies:");
        bogies.forEach(System.out::println);

        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.capacity >= 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Passenger Bogies (Capacity >= 60):");
        highCapacityBogies.forEach(System.out::println);
    }
}