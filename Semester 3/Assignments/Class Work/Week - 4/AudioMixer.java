public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor using this() chaining
    public AudioMixer() {
        this("StandardMix-8", 8, false);
    }

    // Two-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels) {
        // Using this() chaning to initialise variables 
        this(mixerModel, numberOfChannels, false);
    }

    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }

    // Main constructor - all parameters
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;
        System.out.println("Constructor executed for model: " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println("  Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        // Create mixers using different constructors
        AudioMixer m1 = new AudioMixer();                              // no-arg
        AudioMixer m2 = new AudioMixer("PodMix-4", 4);                 // two-arg
        AudioMixer m3 = new AudioMixer("LiveMix-12", 12, true);        // three-arg
        AudioMixer m4 = new AudioMixer("ProMix-16", 16, true, 130.0);  // full

        // Connect devices (array of devices)
        m1.connectDevice("Vocal Mic");
        m1.connectDevice("Guitar");
        m2.connectDevice("Podcast Mic 1");
        m2.connectDevice("Podcast Mic 2");
        m3.connectDevice("DJ Controller");
        m3.connectDevice("Bluetooth Phone");
        m4.connectDevice("Drum Kit");
        m4.connectDevice("Bass");
        m4.connectDevice("Keyboard");

        // Display status
        m1.displayMixerStatus();
        m2.displayMixerStatus();
        m3.displayMixerStatus();
        m4.displayMixerStatus();

    }
}
