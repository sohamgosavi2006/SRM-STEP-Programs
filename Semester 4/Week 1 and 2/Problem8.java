import java.util.*;

public class Problem8 {

    private static final int NUM_SPOTS = 500;
    private static final int HOUR_IN_MS = 3_600_000;

    private enum SpotStatus { EMPTY, OCCUPIED, DELETED }

    static class VehicleEntry {
        final String license;
        final long entryTime;

        VehicleEntry(String license, long entryTime) {
            this.license = license;
            this.entryTime = entryTime;
        }
    }

    static class ParkingLot {
        private final int[] parking;
        private final VehicleEntry[] entries;
        private final SpotStatus[] status;
        private int totalOccupied;
        private int totalProbes;
        private int totalEntries;
        private final long[] hourlyCounts;

        public ParkingLot() {
            parking = new int[NUM_SPOTS];
            entries = new VehicleEntry[NUM_SPOTS];
            status = new SpotStatus[NUM_SPOTS];
            Arrays.fill(status, SpotStatus.EMPTY);
            totalOccupied = 0;
            totalProbes = 0;
            totalEntries = 0;
            hourlyCounts = new long[24];
        }

        private int hash(String license) {
            int h = 0;
            for (char c : license.toCharArray()) {
                h = (h * 31 + c) % NUM_SPOTS;
            }
            return h;
        }

        public String parkVehicle(String license) {
            int start = hash(license);
            int i = 0;
            int spot = start;

            while (i < NUM_SPOTS) {
                totalProbes++;
                if (status[spot] == SpotStatus.EMPTY || status[spot] == SpotStatus.DELETED) {
                    parking[spot] = 1;
                    entries[spot] = new VehicleEntry(license, System.currentTimeMillis());
                    status[spot] = SpotStatus.OCCUPIED;
                    totalOccupied++;
                    totalEntries++;
                    int hour = (int) (System.currentTimeMillis() % (24 * HOUR_IN_MS)) / HOUR_IN_MS;
                    hourlyCounts[hour]++;
                    if (i == 0) {
                        return "Assigned spot #" + spot + " (0 probes)";
                    }
                    return "Assigned spot #" + spot + " (" + i + " probe" + (i > 1 ? "s" : "") + ")";
                }
                i++;
                spot = (start + i) % NUM_SPOTS;
            }
            return "Parking full";
        }

        public String exitVehicle(String license) {
            int start = hash(license);
            int i = 0;
            int spot = start;

            while (i < NUM_SPOTS) {
                if (status[spot] == SpotStatus.OCCUPIED && entries[spot].license.equals(license)) {
                    long now = System.currentTimeMillis();
                    long durationMs = now - entries[spot].entryTime;
                    long hours = durationMs / HOUR_IN_MS;
                    long minutes = (durationMs % HOUR_IN_MS) / 60_000;
                    double fee = 2.0 + 4.0 * hours + 0.05 * minutes;
                    parking[spot] = 0;
                    entries[spot] = null;
                    status[spot] = SpotStatus.EMPTY;
                    totalOccupied--;
                    return "Spot #" + spot + " freed, Duration: " + hours + "h " + minutes + "m, Fee: $" + String.format("%.2f", fee);
                }
                i++;
                spot = (start + i) % NUM_SPOTS;
            }
            return "Vehicle not found";
        }

        public Map<String, Object> getStatistics() {
            double occupancy = NUM_SPOTS == 0 ? 0.0 : (double) totalOccupied / NUM_SPOTS;
            double avgProbes = totalEntries == 0 ? 0.0 : (double) totalProbes / totalEntries;
            int peakHour = 0;
            long peakCount = 0;
            for (int i = 0; i < 24; i++) {
                if (hourlyCounts[i] > peakCount) {
                    peakCount = hourlyCounts[i];
                    peakHour = i;
                }
            }
            Map<String, Object> result = new LinkedHashMap<>();
            result.put("Occupancy", String.format("%.1f%%", occupancy * 100));
            result.put("Avg Probes", String.format("%.1f", avgProbes));
            result.put("Peak Hour", String.format("%d-%d", peakHour, (peakHour + 1) % 24));
            return result;
        }
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        System.out.println("parkVehicle(\"ABC-1234\") → " + lot.parkVehicle("ABC-1234"));
        System.out.println("parkVehicle(\"ABC-1235\") → " + lot.parkVehicle("ABC-1235"));
        System.out.println("parkVehicle(\"XYZ-9999\") → " + lot.parkVehicle("XYZ-9999"));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) { /* ignore */ }

        System.out.println("exitVehicle(\"ABC-1234\") → " + lot.exitVehicle("ABC-1234"));

        System.out.println("getStatistics() → " + lot.getStatistics());
    }
}