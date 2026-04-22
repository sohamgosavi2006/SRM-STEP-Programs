import java.util.*;

public class VirtualPet {
    final String petID; // unique ID for each pet
    String petName, species;
    int age, happiness, health;
    boolean isGhost = false; // true if pet has died

    // Evolution stages
    static final String[] EVOLUTION_STAGES = {
            "Egg", "Baby", "Child", "Teen", "Adult", "Elder"
    };

    static int totalPetsCreated = 0; // track how many pets created


    // Default constructor: mysterious Egg
    public VirtualPet() {
        this(generatePetId(), "Mysterious Egg", randomSpecies(), 0, 50, 50);
    }

    // Constructor: Baby stage with name only
    public VirtualPet(String petName) {
        this(generatePetId(), petName, randomSpecies(), 1, 60, 60);
    }

    // Constructor: Child stage with name + species
    public VirtualPet(String petName, String species) {
        this(generatePetId(), petName, species, 3, 70, 70);
    }

    // Full constructor (main one all others call)
    public VirtualPet(String id, String petName, String species, int age, int happiness, int health) {
        this.petID = id;
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        totalPetsCreated++;
    }

    // Generate random unique ID for each pet
    static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString().substring(0, 8);
    }

    // Pick random species from list
    static String randomSpecies() {
        String[] speciesList = {"Dragon", "Cat", "Dog", "Phoenix", "Unicorn"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }


    // Feed pet increases happiness and health
    void feedPet() {
        if (!isGhost) {
            happiness += 5;
            health += 5;
            System.out.println(petName + " enjoyed the food!");
        }
    }

    // Play increases happiness but decreases health slightly
    void playWithPet() {
        if (!isGhost) {
            happiness += 10;
            health -= 2;
            System.out.println(petName + " had fun playing!");
        }
    }

    // Heal pet increases health
    void healPet() {
        if (!isGhost) {
            health += 15;
            System.out.println(petName + " is feeling better!");
        }
    }

    // Check if pet should evolve based on age
    void evolvePet() {
        if (isGhost) return; // Ghost cannot evolve

        String stage = getPetStatus();
        if (age >= 0 && age < 2 && !stage.equals("Egg")) {
            System.out.println(petName + " reverted to Egg? (strange bug!)");
        } else if (age >= 2 && age < 4 && !stage.equals("Baby")) {
            System.out.println(petName + " evolved into Baby!");
        } else if (age >= 4 && age < 7 && !stage.equals("Child")) {
            System.out.println(petName + " evolved into Child!");
        } else if (age >= 7 && age < 10 && !stage.equals("Teen")) {
            System.out.println(petName + " evolved into Teen!");
        } else if (age >= 10 && age < 15 && !stage.equals("Adult")) {
            System.out.println(petName + " evolved into Adult!");
        } else if (age >= 15 && !stage.equals("Elder")) {
            System.out.println(petName + " evolved into Elder!");
        }
    }

    // Simulate one day of pet's life
    void simulateDay() {
        if (isGhost) return;

        age++;
        happiness += new Random().nextInt(5) - 2; // random happiness change
        health += new Random().nextInt(7) - 3; // random health change

        // If health drops to 0 or less, pet becomes ghost
        if (health <= 0) {
            isGhost = true;
            species = "Ghost";
            System.out.println(petName + " has died and become a Ghost!");
        } else {
            evolvePet();
        }
    }

    // Return current evolution stage based on age
    String getPetStatus() {
        if (isGhost) return "Ghost";
        if (age < 2) return EVOLUTION_STAGES[0];
        else if (age < 4) return EVOLUTION_STAGES[1];
        else if (age < 7) return EVOLUTION_STAGES[2];
        else if (age < 10) return EVOLUTION_STAGES[3];
        else if (age < 15) return EVOLUTION_STAGES[4];
        else return EVOLUTION_STAGES[5];
    }

    // Print pet details
    void displayStatus() {
        System.out.println("[" + petID + "] " + petName + " (" + species + ")");
        System.out.println(" Age: " + age + ", Happiness: " + happiness + ", Health: " + health);
        System.out.println(" Stage: " + getPetStatus());
    }

   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create 3 pets in daycare
        VirtualPet v1 = new VirtualPet();
        VirtualPet v2 = new VirtualPet("Fluffy");
        VirtualPet v3 = new VirtualPet("Spike", "Dragon");

        VirtualPet[] daycare = {v1, v2, v3};

        // Simulate 10 days
        for (int day = 1; day <= 10; day++) {
            System.out.println("Day " + day );
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                pet.displayStatus();
            }
        }

        // Print total number of pets created
        System.out.println("Total Pets Created: " + VirtualPet.totalPetsCreated);
    }
}
