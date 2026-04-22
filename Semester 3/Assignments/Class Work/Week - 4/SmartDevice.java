public class SmartDevice {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // Constructor with parameter names matching field names
    public SmartDevice(String deviceName, String location,
                       boolean isOnline, double powerConsumption) {
        this.deviceName = deviceName;
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;
        this.connectedDevices = new String[5];
        this.connectionCount = 0;
    }

    // Method using this for parameter disambiguation
    public SmartDevice updateLocation(String location) {
        this.location = location;
        System.out.println(this.deviceName + " moved to " + this.location);
        return this;
    }

    public SmartDevice updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
        System.out.println("Power consumption updated for " + this.deviceName);
        return this; // enable chaining
    }

    // Method returning this for chaining
    public SmartDevice setOnline(boolean isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    public SmartDevice connectToDevice(String deviceName) {
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        } else {
            System.out.println(this.deviceName + ": Connection list full");
        }
        return this; // Enable method chaining
    }

    public SmartDevice rename(String deviceName) {
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this;
    }

    public void displayDeviceInfo() {
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println("  -> " + this.connectedDevices[i]);
        }
    }

    // Method that calls other methods using this, now chainable
    public SmartDevice performInitialSetup() {
        this.setOnline(true);
        System.out.println(this.deviceName + " initial setup completed");
        return this;  // allow chaining
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");
        // Create devices with parameter names matching field names
        SmartDevice device = new SmartDevice("Living Room Hub", "Living Room", false, 5.0);
        SmartDevice lamp = new SmartDevice("Desk Lamp", "Study", true, 12.0);

        // Method Chaining --->
        // Method chaining means calling multiple methods on the same object in a single line, 
        // because each method returns the Object itself (this) instead of void
        device.performInitialSetup()
              .connectToDevice("WiFi Router")
              .connectToDevice("Alexa")
              .rename("Main Hub")
              .updateLocation("Hallway")
              .updatePowerConsumption(5.5)
              .setOnline(true);

        // Demonstrate this keyword in various contexts
        lamp.connectToDevice("Main Hub").setOnline(true);

        device.displayDeviceInfo();
        lamp.displayDeviceInfo();
    }
}
