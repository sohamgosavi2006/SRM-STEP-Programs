import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmt {

    static boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("========================================\n");

        String[] bogieIDs = {"BG101","BG205","BG309","BG412","BG550"};
        String searchKey = "BG309";

        System.out.println("Bogie IDs: " + Arrays.toString(bogieIDs));
        System.out.println("Searching for: " + searchKey);

        boolean found = linearSearch(bogieIDs, searchKey);

        if (found) {
            System.out.println("Bogie found in the train.");
        } else {
            System.out.println("Bogie not found.");
        }

        System.out.println("\nUC18 execution completed...");
    }

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(linearSearch(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(linearSearch(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(linearSearch(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG550"};
        assertTrue(linearSearch(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(linearSearch(arr, "BG101"));
    }
}