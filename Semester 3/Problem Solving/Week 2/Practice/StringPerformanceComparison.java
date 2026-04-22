public class StringPerformanceComparison {
    public static void main(String[] args) {
        System.out.println("=== PERFORMANCE COMPARISON ===");

        long startTime = System.nanoTime();
        String result1 = concatenateWithString(10000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(10000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(10000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        System.out.println("\n=== STRINGBUILDER METHODS DEMO ===");
        demonstrateStringBuilderMethods();

        System.out.println("\n=== THREAD SAFETY DEMO ===");
        demonstrateThreadSafety();

        System.out.println("\n=== STRING COMPARISON METHODS ===");
        compareStringComparisonMethods();

        System.out.println("\n=== MEMORY EFFICIENCY DEMO ===");
        demonstrateMemoryEfficiency();
    }

    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i;
        }
        return result;
    }

    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i);
        }
        return sb.toString();
    }

    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("Original: " + sb);

        sb.append("!!!");
        System.out.println("append(): " + sb);

        sb.insert(5, " Java");
        System.out.println("insert(): " + sb);

        sb.delete(5, 10);
        System.out.println("delete(): " + sb);

        sb.deleteCharAt(0);
        System.out.println("deleteCharAt(): " + sb);

        sb.reverse();
        System.out.println("reverse(): " + sb);

        sb.reverse().replace(0, 5, "Hey");
        System.out.println("replace(): " + sb);

        sb.setCharAt(0, 'h');
        System.out.println("setCharAt(): " + sb);

        System.out.println("capacity(): " + sb.capacity());
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity(100): " + sb.capacity());

        sb.trimToSize();
        System.out.println("trimToSize(): " + sb.capacity());
    }

    public static void demonstrateThreadSafety() {
        StringBuffer safeBuffer = new StringBuffer("Start-");

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                safeBuffer.append(Thread.currentThread().getName()).append(" ");
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("StringBuffer (thread-safe): " + safeBuffer);

        StringBuilder unsafeBuilder = new StringBuilder("Start-");
        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                unsafeBuilder.append(Thread.currentThread().getName()).append(" ");
            }
        };

        Thread t3 = new Thread(task2, "T3");
        Thread t4 = new Thread(task2, "T4");
        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("StringBuilder (not thread-safe): " + unsafeBuilder);
    }

    // Compare string comparison methods
    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println("str1 == str2 : " + (str1 == str2));
        System.out.println("str1 == str3 : " + (str1 == str3));

        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));

        System.out.println("str1.equalsIgnoreCase(\"hello\"): " + str1.equalsIgnoreCase("hello"));

        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2));
        System.out.println("str1.compareToIgnoreCase(\"hello\"): " + str1.compareToIgnoreCase("hello"));
    }

    public static void demonstrateMemoryEfficiency() {
        Runtime runtime = Runtime.getRuntime();

        System.gc();
        long before = runtime.freeMemory();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "Java";
        }
        long after = runtime.freeMemory();
        System.out.println("Memory used with String concatenation: " + (before - after) + " bytes");

        System.gc();
        before = runtime.freeMemory();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("Java");
        }
        after = runtime.freeMemory();
        System.out.println("Memory used with StringBuilder: " + (before - after) + " bytes");

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        System.out.println("s1 == s2 (string pool): " + (s1 == s2));
        System.out.println("s1 == s3 (new object): " + (s1 == s3));
    }
}
