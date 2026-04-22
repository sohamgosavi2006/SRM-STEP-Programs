import java.util.HashMap;
import java.util.Map;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("==================================");

        Map<String, Integer> capacityMap = new HashMap<>();

        capacityMap.put("PB101", 72);
        capacityMap.put("PB102", 60);
        capacityMap.put("GB201", 2000);
        capacityMap.put("PB103", 40);
        capacityMap.put("GB202", 1500);

        System.out.println("Bogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println("Bogie ID: " + entry.getKey() + ", Capacity: " + entry.getValue());
        }
    }
}