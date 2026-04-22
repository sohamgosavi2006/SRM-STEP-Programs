import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementSystem {

    static boolean searchBogie(List<String> bogies, String key) {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (String id : bogies) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC20 - Exception Handling During Search ");
        System.out.println("========================================\n");

        List<String> bogieIDs = new ArrayList<>();
        bogieIDs.add("BG101");
        bogieIDs.add("BG205");
        bogieIDs.add("BG309");

        String searchKey = "BG205";

        try {
            boolean found = searchBogie(bogieIDs, searchKey);

            if (found) {
                System.out.println("Bogie found in the train.");
            } else {
                System.out.println("Bogie not found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nUC20 execution completed...");
    }

    @Test
    void testSearch_WithValidData() {
        List<String> list = Arrays.asList("BG101","BG205","BG309");
        assertTrue(searchBogie(list, "BG205"));
    }

    @Test
    void testSearch_BogieNotFound() {
        List<String> list = Arrays.asList("BG101","BG205","BG309");
        assertFalse(searchBogie(list, "BG999"));
    }

    @Test
    void testSearch_EmptyListThrowsException() {
        List<String> list = new ArrayList<>();
        Exception ex = assertThrows(IllegalStateException.class, () -> {
            searchBogie(list, "BG101");
        });
        assertEquals("No bogies available for search", ex.getMessage());
    }

    @Test
    void testSearch_FirstElementMatch() {
        List<String> list = Arrays.asList("BG101","BG205","BG309");
        assertTrue(searchBogie(list, "BG101"));
    }

    @Test
    void testSearch_SingleElementList() {
        List<String> list = Arrays.asList("BG101");
        assertTrue(searchBogie(list, "BG101"));
    }
}