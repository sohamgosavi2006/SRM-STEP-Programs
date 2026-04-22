import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("==================================");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper PB101", 72));
        bogies.add(new Bogie("AC Chair PB102", 60));
        bogies.add(new Bogie("First Class PB103", 40));

        System.out.println("Unsorted Passenger Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        Collections.sort(bogies, new Comparator<Bogie>() {
            public int compare(Bogie b1, Bogie b2) {
                return b2.capacity - b1.capacity; // descending order
            }
        });

        System.out.println("\nPassenger Bogies Sorted by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}