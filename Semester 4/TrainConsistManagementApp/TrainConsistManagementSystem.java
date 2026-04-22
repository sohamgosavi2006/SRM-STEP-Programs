import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementSystem {
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical")
                        || b.cargo.equalsIgnoreCase("Petroleum"));
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("========================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        boolean safe = isTrainSafe(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + safe);

        if (safe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertTrue(isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Grain"),
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();
        assertTrue(isTrainSafe(list));
    }
}