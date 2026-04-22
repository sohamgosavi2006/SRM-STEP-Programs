import java.util.Scanner;

public class StringPerformance {

    public static long[] testStringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s = s + "a";
        }
        long end = System.currentTimeMillis();
        return new long[]{end - start, s.length()};
    }

    public static long[] testStringBuilder(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        return new long[]{end - start, sb.length()};
    }

    public static long[] testStringBuffer(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append("a");
        }
        long end = System.currentTimeMillis();
        return new long[]{end - start, sbuf.length()};
    }

    public static void displayResults(long[] stringRes, long[] builderRes, long[] bufferRes) {
        System.out.printf("%-20s %-20s %-20s\n", "Method", "Time (ms)", "Final Length");
        System.out.printf("%-20s %-20d %-20d\n", "String (+)", stringRes[0], stringRes[1]);
        System.out.printf("%-20s %-20d %-20d\n", "StringBuilder", builderRes[0], builderRes[1]);
        System.out.printf("%-20s %-20d %-20d\n", "StringBuffer", bufferRes[0], bufferRes[1]);

        String fastest = "String (+)";
        long minTime = stringRes[0];
        if (builderRes[0] < minTime) {
            minTime = builderRes[0];
            fastest = "StringBuilder";
        }
        if (bufferRes[0] < minTime) {
            minTime = bufferRes[0];
            fastest = "StringBuffer";
        }
        System.out.println("Most efficient: " + fastest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of iterations:");
        int iterations = sc.nextInt();

        long[] stringRes = testStringConcat(iterations);
        long[] builderRes = testStringBuilder(iterations);
        long[] bufferRes = testStringBuffer(iterations);

        displayResults(stringRes, builderRes, bufferRes);

        sc.close();
    }
}
