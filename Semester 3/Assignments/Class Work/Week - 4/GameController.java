public class GameController {
    // Instance variables for controller configuration
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;        // 0-100
    private double sensitivity;      // 0.1-3.0

    // Default constructor - creates standard gaming setup
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // Parameterized constructor for custom configuration
    public GameController(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        // Validate values via clamping
        this.batteryLevel = clamp(batteryLevel, 0, 100);
        this.sensitivity = clamp(sensitivity, 0.1, 3.0);
    }

    // Two-parameter convenience constructor
    public GameController(String brand, String connectionType) {
        this(brand, connectionType, true, 100, 1.0);
    }

    private int clamp(int v, int lo, int hi) {
        return Math.max(lo, Math.min(hi, v));
    }
    private double clamp(double v, double lo, double hi) {
        if (v < lo) 
            return lo;
        if (v > hi) 
            return hi;
        return v;
    }

    // Methods to test functionality
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("--- Controller Configuration ---");
        System.out.println("Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");
        // Create controller with default constructor
        GameController c1 = new GameController();
        // Create controller with full parameterized constructor
        GameController c2 = new GameController("ProX", "Bluetooth", false, 75, 2.2);
        // Create controller with convenience constructor
        GameController c3 = new GameController("LitePad", "USB-C");

        // Test all methods on each controller
        c1.displayConfiguration(); c1.calibrateController(); c1.testVibration();
        System.out.println();
        c2.displayConfiguration(); c2.calibrateController(); c2.testVibration();
        System.out.println();
        c3.displayConfiguration(); c3.calibrateController(); c3.testVibration();

        // Compare different configurations
        System.out.println();
        System.out.println("c1 vs c2 sensitivity delta: " + (c1.sensitivity - c2.sensitivity));
        System.out.println("c1 vs c2 battery delta: " + (c1.batteryLevel - c2.batteryLevel));
    }
}
