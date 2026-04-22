import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementSystem {

    static void sortBogieNames(String[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC17 - Sort Bogie Names ");
        System.out.println("========================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        sortBogieNames(bogieNames);

        System.out.println("\nAfter Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 execution completed...");
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General","Luxury","Sleeper"}, arr);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Luxury","Sleeper"}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General"}, arr);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Sleeper","Sleeper"}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        sortBogieNames(arr);
        assertArrayEquals(new String[]{"Sleeper"}, arr);
    }
}