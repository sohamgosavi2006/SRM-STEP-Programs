public class Counter {
    static int count = 0;

    public Counter() {
        count++; // Increment count whenever an object is created
    }

    // Static method getCount()
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        // Create several Counter objects
        Counter a = new Counter();
        Counter b = new Counter();
        Counter c = new Counter();
        // Display number of objects created
        System.out.println("Objects created: " + Counter.getCount());
    }
}
