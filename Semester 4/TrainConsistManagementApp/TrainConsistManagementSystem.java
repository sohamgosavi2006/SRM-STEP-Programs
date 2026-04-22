import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementSystem {

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    static List<PassengerBogie> filterWithLoop(List<PassengerBogie> list) {
        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie b : list) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    static List<PassengerBogie> filterWithStream(List<PassengerBogie> list) {
        return list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("========================================\n");

        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new PassengerBogie("Sleeper", (i % 100)));
        }

        long startLoop = System.nanoTime();
        List<PassengerBogie> loopResult = filterWithLoop(bogies);
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<PassengerBogie> streamResult = filterWithStream(bogies);
        long endStream = System.nanoTime();

        long loopTime = endLoop - startLoop;
        long streamTime = endStream - startStream;

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("\nExecution Time (Loop): " + loopTime + " ns");
        System.out.println("Execution Time (Stream): " + streamTime + " ns");

        System.out.println("\nUC13 performance comparison completed...");
    }

    @Test
    void testLoopFilteringLogic() {
        List<PassengerBogie> list = Arrays.asList(
                new PassengerBogie("A", 50),
                new PassengerBogie("B", 70)
        );
        List<PassengerBogie> result = filterWithLoop(list);
        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<PassengerBogie> list = Arrays.asList(
                new PassengerBogie("A", 50),
                new PassengerBogie("B", 80)
        );
        List<PassengerBogie> result = filterWithStream(list);
        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<PassengerBogie> list = Arrays.asList(
                new PassengerBogie("A", 40),
                new PassengerBogie("B", 90),
                new PassengerBogie("C", 70)
        );
        assertEquals(
                filterWithLoop(list).size(),
                filterWithStream(list).size()
        );
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<PassengerBogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new PassengerBogie("X", i));
        }

        long start = System.nanoTime();
        filterWithLoop(list);
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<PassengerBogie> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(new PassengerBogie("X", i % 120));
        }

        List<PassengerBogie> result = filterWithStream(list);
        assertTrue(result.size() > 0);
    }
}