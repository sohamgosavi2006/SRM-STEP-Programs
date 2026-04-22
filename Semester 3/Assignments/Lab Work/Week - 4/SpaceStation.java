import java.util.*;

// Enum for crew rank
enum CrewRank {
    CADET(1), OFFICER(2), COMMANDER(3), CAPTAIN(4), ADMIRAL(5);
    private final int level;
    CrewRank(int level) { this.level = level; }
    public int getLevel() { return level; }
}

class SpaceCrew {
    final String crewId;
    final String homeplanet;
    final CrewRank initialRank;

    String name;
    CrewRank currentRank;
    int skillLevel;
    int missionCount;
    int spaceHours;

    static final String STATION_NAME = "Stellar Odyssey";
    static final int MAX_CREW_CAPACITY = 50;

    // Emergency recruitment
    public SpaceCrew(String name) {
        this(UUID.randomUUID().toString(), name, randomPlanet(), CrewRank.CADET, 1, 0, 0);
    }

    // Standard recruitment
    public SpaceCrew(String name, String homeplanet, CrewRank rank) {
        this(UUID.randomUUID().toString(), name, homeplanet, rank, 1, 0, 0);
    }

    // Experienced transfer
    public SpaceCrew(String name, String homeplanet, CrewRank rank, int missionCount, int skillLevel) {
        this(UUID.randomUUID().toString(), name, homeplanet, rank, skillLevel, missionCount, missionCount * 100);
    }

    // Full constructor
    public SpaceCrew(String crewId, String name, String homeplanet, CrewRank rank, int skillLevel, int missionCount, int spaceHours) {
        this.crewId = crewId;
        this.name = name;
        this.homeplanet = homeplanet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.skillLevel = skillLevel;
        this.missionCount = missionCount;
        this.spaceHours = spaceHours;
    }

    final String getCrewIdentification() {
        return "ID:" + crewId + " | Planet:" + homeplanet;
    }

    final boolean canBePromoted() {
        return currentRank.getLevel() < CrewRank.ADMIRAL.getLevel();
    }

    final int calculateSpaceExperience() {
        return (missionCount * 10) + (spaceHours / 50) + skillLevel;
    }

    static String randomPlanet() {
        String[] planets = {"Mars", "Venus", "Europa", "Titan", "Ganymede"};
        return planets[new Random().nextInt(planets.length)];
    }
}

class PilotCrew extends SpaceCrew {
    final String flightCertification;
    public PilotCrew(String name, String cert) {
        super(name);
        this.flightCertification = cert;
    }
}

class ScienceCrew extends SpaceCrew {
    final String specialization;
    public ScienceCrew(String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }
}

class EngineerCrew extends SpaceCrew {
    final String certification;
    public EngineerCrew(String name, String certification) {
        super(name);
        this.certification = certification;
    }
}

final class SpaceStationRegistry {
    private static List<SpaceCrew> crewList = new ArrayList<>();

    static void addCrew(SpaceCrew crew) {
        if (crewList.size() < SpaceCrew.MAX_CREW_CAPACITY) {
            crewList.add(crew);
            System.out.println(crew.name + " added to station.");
        }
    }

    static void showAllCrew() {
        for (SpaceCrew c : crewList) {
            System.out.println(c.name + " | Rank: " + c.currentRank + " | " + c.getCrewIdentification());
        }
    }

    static void handleEmergency() {
        boolean hasPilot = crewList.stream().anyMatch(c -> c instanceof PilotCrew);
        boolean hasEngineer = crewList.stream().anyMatch(c -> c instanceof EngineerCrew);
        boolean hasScience = crewList.stream().anyMatch(c -> c instanceof ScienceCrew);

        if (hasPilot && hasEngineer && hasScience) {
            System.out.println("Emergency handled successfully!");
        } else {
            System.out.println("Not enough crew diversity for crisis!");
        }
    }
}

public class SpaceStation {
    public static void main(String[] args) {
        PilotCrew p1 = new PilotCrew("John", "Advanced Flight");
        ScienceCrew s1 = new ScienceCrew("Alice", "Astrobiology");
        EngineerCrew e1 = new EngineerCrew("Bob", "Mechanical Systems");

        SpaceStationRegistry.addCrew(p1);
        SpaceStationRegistry.addCrew(s1);
        SpaceStationRegistry.addCrew(e1);

        SpaceStationRegistry.showAllCrew();
        SpaceStationRegistry.handleEmergency();
    }
}
