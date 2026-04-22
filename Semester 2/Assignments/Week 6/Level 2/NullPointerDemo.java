public class NullPointerDemo {
    public static void main(String[] args) {
        generateNullPointerException();
        handleNullPointerException();
    }

    public static void generateNullPointerException() {
        String text = null;
        text.length();
    }

    public static void handleNullPointerException() {
        String text = null;
        try {
            text.length();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}