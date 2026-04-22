import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem2 {

    private final Map<String, AtomicInteger> stock;
    private final Map<String, Queue<Long>> waitingList;

    public Problem2() {
        stock = new ConcurrentHashMap<>();
        waitingList = new ConcurrentHashMap<>();
        stock.put("IPHONE15_256GB", new AtomicInteger(100));
        waitingList.put("IPHONE15_256GB", new LinkedList<>());
    }

    public int checkStock(String productId) {
        AtomicInteger stockCount = stock.get(productId);
        if (stockCount == null) {
            return 0;
        }
        return stockCount.get();
    }

    public String purchaseItem(String productId, long userId) {
        AtomicInteger stockCount = stock.get(productId);
        if (stockCount == null) {
            return "Invalid product ID";
        }

        int current = stockCount.get();
        if (current > 0 && stockCount.compareAndSet(current, current - 1)) {
            return String.format("Success, %d units remaining", stockCount.get());
        }

        Queue<Long> waitQueue = waitingList.computeIfAbsent(productId, k -> new LinkedList<>());
        synchronized (waitQueue) {
            waitQueue.add(userId);
            int position = waitQueue.size();
            return String.format("Added to waiting list, position #%d", position);
        }
    }

    public static void main(String[] args) {
        Problem2 inv = new Problem2();

        System.out.println("checkStock(\"IPHONE15_256GB\") → " + inv.checkStock("IPHONE15_256GB") + " units available");

        System.out.println("purchaseItem(\"IPHONE15_256GB\", userId=12345) → " + inv.purchaseItem("IPHONE15_256GB", 12345));
        System.out.println("purchaseItem(\"IPHONE15_256GB\", userId=67890) → " + inv.purchaseItem("IPHONE15_256GB", 67890));

        for (int i = 0; i < 98; i++) {
            inv.purchaseItem("IPHONE15_256GB", 1000 + i);
        }

        System.out.println("checkStock(\"IPHONE15_256GB\") → " + inv.checkStock("IPHONE15_256GB") + " units available");

        System.out.println("purchaseItem(\"IPHONE15_256GB\", userId=99999) → " + inv.purchaseItem("IPHONE15_256GB", 99999));
    }
}