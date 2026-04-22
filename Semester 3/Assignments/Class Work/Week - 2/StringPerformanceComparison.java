public class StringPerformanceComparison { 
    public static void main(String[] args) { 
        System.out.println("=== PERFORMANCE COMPARISON ==="); 

        long startTime = System.nanoTime(); 
        String result1 = concatenateWithString(1000); 
        long endTime = System.nanoTime(); 
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns"); 

        startTime = System.nanoTime(); 
        String result2 = concatenateWithStringBuilder(1000); 
        endTime = System.nanoTime(); 
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns"); 

        startTime = System.nanoTime(); 
        String result3 = concatenateWithStringBuffer(1000); 
        endTime = System.nanoTime(); 
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns"); 

        Runtime runtime = Runtime.getRuntime(); 
        runtime.gc(); 
        long usedMemory = runtime.totalMemory() - runtime.freeMemory(); 
        System.out.println("Approximate memory usage: " + usedMemory + " bytes"); 

        demonstrateThreadSafety(); 

        System.out.println("Practical Use: String for small immutable text, StringBuilder for single-threaded mutable text, StringBuffer for multi-threaded mutable text"); 
    } 

    public static String concatenateWithString(int count) { 
        String s = ""; 
        for(int i=0;i<count;i++){ 
            s += "x"; 
        } 
        return s; 
    } 

    public static String concatenateWithStringBuilder(int count) { 
        StringBuilder sb = new StringBuilder(); 
        for(int i=0;i<count;i++){ 
            sb.append("x"); 
        } 
        return sb.toString(); 
    } 

    public static String concatenateWithStringBuffer(int count) { 
        StringBuffer sb = new StringBuffer(); 
        for(int i=0;i<count;i++){ 
            sb.append("x"); 
        } 
        return sb.toString(); 
    } 

    public static void demonstrateThreadSafety() { 
        StringBuilder sb = new StringBuilder("A"); 
        StringBuffer sbuf = new StringBuffer("A"); 

        Thread t1 = new Thread(() -> { 
            for(int i=0;i<1000;i++){ sb.append("B"); } 
        }); 
        Thread t2 = new Thread(() -> { 
            for(int i=0;i<1000;i++){ sb.append("C"); } 
        }); 
        t1.start(); 
        t2.start(); 
        try{ t1.join(); t2.join(); }catch(Exception e){} 
        System.out.println("StringBuilder length (may vary due to no thread safety): " + sb.length()); 

        Thread t3 = new Thread(() -> { 
            for(int i=0;i<1000;i++){ sbuf.append("B"); } 
        }); 
        Thread t4 = new Thread(() -> { 
            for(int i=0;i<1000;i++){ sbuf.append("C"); } 
        }); 
        t3.start(); 
        t4.start(); 
        try{ t3.join(); t4.join(); }catch(Exception e){} 
        System.out.println("StringBuffer length (consistent due to thread safety): " + sbuf.length()); 
    } 
}
