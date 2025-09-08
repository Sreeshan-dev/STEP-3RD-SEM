package STEP.WEEK4.LAB;

import java.util.*;

class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private int stageIndex;
    private boolean isGhost;

    private static int totalPetsCreated = 0;
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};

    // Default constructor: mysterious egg
    public VirtualPet() {
        this("MysteryPet", getRandomSpecies(), 0, 50, 50, 0);
    }

    // Constructor with name only: baby stage
    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, 1);
    }

    // Constructor with name + species: child stage
    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70, 2);
    }

    // Full constructor
    public VirtualPet(String petName, String species, int age, int happiness, int health, int stageIndex) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIndex = stageIndex;
        this.isGhost = false;
        totalPetsCreated++;
    }

    // Generate unique pet ID
    public static String generatePetId() {
        return "PET-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    // Random species generator
    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Wolf", "Cat", "Dog"};
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }

    // Feed pet
    public void feedPet() {
        if (!isGhost) {
            happiness += 5;
            health += 10;
            System.out.println(petName + " was fed. 🍎 Health +10, Happiness +5");
        } else {
            System.out.println(petName + " is a ghost 👻... it cannot eat!");
        }
    }

    // Play with pet
    public void playWithPet() {
        if (!isGhost) {
            happiness += 10;
            health -= 5;
            System.out.println(petName + " played! 🎮 Happiness +10, Health -5");
        } else {
            System.out.println(petName + " is haunting instead of playing... 👻");
        }
    }

    // Heal pet
    public void healPet() {
        if (!isGhost) {
            health += 15;
            System.out.println(petName + " was healed. ❤️ Health +15");
        } else {
            System.out.println("Ghosts cannot be healed...");
        }
    }

    // Simulate a day
    public void simulateDay() {
        if (isGhost) {
            System.out.println(petName + " the ghost wanders silently... 👻");
            return;
        }
        age++;
        happiness -= 3;
        health -= 2;
        System.out.println("A day passes for " + petName + "...");
        if (health <= 0) {
            becomeGhost();
        } else {
            evolvePet();
        }
    }

    // Evolve pet
    public void evolvePet() {
        if (!isGhost && stageIndex < EVOLUTION_STAGES.length - 1) {
            if (age % 3 == 0) { // evolve every 3 days
                stageIndex++;
                System.out.println(petName + " evolved into " + EVOLUTION_STAGES[stageIndex] + " stage! 🌟");
            }
        }
    }

    // Become ghost
    private void becomeGhost() {
        isGhost = true;
        species = "Ghost";
        System.out.println(petName + " has died and become a Ghost... 👻");
    }

    // Get pet status
    public String getPetStatus() {
        return String.format("[%s] %s (%s) | Age: %d | Health: %d | Happiness: %d | Stage: %s",
                petId, petName, species, age, health, happiness, isGhost ? "Ghost" : EVOLUTION_STAGES[stageIndex]);
    }

    // Static method to get total pets
    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }
}

// Main class
public class VirtualPetSimulator {
    public static void main(String[] args) {
        List<VirtualPet> daycare = new ArrayList<>();

        // Create pets with different constructors
        daycare.add(new VirtualPet());
        daycare.add(new VirtualPet("Fluffy"));
        daycare.add(new VirtualPet("Blaze", "Dragon"));
        daycare.add(new VirtualPet("Aqua", "Phoenix", 5, 80, 90, 3));

        // Simulate few days
        for (int day = 1; day <= 5; day++) {
            System.out.println("\n=== Day " + day + " ===");
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                pet.feedPet();
                pet.playWithPet();
                System.out.println(pet.getPetStatus());
            }
        }

        System.out.println("\nTotal Pets Created: " + VirtualPet.getTotalPetsCreated());
    }
}

