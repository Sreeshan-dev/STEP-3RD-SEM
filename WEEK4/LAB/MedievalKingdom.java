package STEP.WEEK4.LAB;

// Abstract Base Class
abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    public MagicalStructure() {
        this("Unknown Structure", 10, "Unknown", true);
    }

    public MagicalStructure(String structureName) {
        this(structureName, 20, "Central Land", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

// WizardTower
class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;

    public WizardTower() {
        this("Wizard Tower", 50, "Mountain", true, 5, new String[]{"Fireball"});
    }

    public WizardTower(String structureName, int spellCapacity) {
        this(structureName, 60, "Hilltop", true, spellCapacity, new String[]{"Ice Blast"});
    }

    public WizardTower(String structureName, int magicPower, String location, boolean isActive, int spellCapacity, String[] knownSpells) {
        super(structureName, magicPower, location, isActive);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a powerful spell!");
    }
}

// EnchantedCastle
class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    public EnchantedCastle() {
        this("Enchanted Castle", 70, "Valley", true, 100, true);
    }

    public EnchantedCastle(String structureName, int defenseRating) {
        this(structureName, 80, "River Side", true, defenseRating, false);
    }

    public EnchantedCastle(String structureName, int magicPower, String location, boolean isActive, int defenseRating, boolean hasDrawbridge) {
        super(structureName, magicPower, location, isActive);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " boosts defense with magic!");
    }
}

// MysticLibrary
class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    public MysticLibrary() {
        this("Mystic Library", 40, "Forest", true, 500, "Latin");
    }

    public MysticLibrary(String structureName, int bookCount) {
        this(structureName, 50, "City Center", true, bookCount, "Greek");
    }

    public MysticLibrary(String structureName, int magicPower, String location, boolean isActive, int bookCount, String ancientLanguage) {
        super(structureName, magicPower, location, isActive);
        this.bookCount = bookCount;
        this.ancientLanguage = ancientLanguage;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts knowledge-based magic!");
    }
}

// DragonLair
class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    public DragonLair() {
        this("Dragon Lair", 90, "Cave", true, "Fire Dragon", 1000);
    }

    public DragonLair(String structureName, String dragonType) {
        this(structureName, 100, "Mountain Cave", true, dragonType, 2000);
    }

    public DragonLair(String structureName, int magicPower, String location, boolean isActive, String dragonType, int treasureValue) {
        super(structureName, magicPower, location, isActive);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fury!");
    }
}

// Kingdom Manager
class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1.isActive && s2.isActive;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " defeats " + defender.structureName;
        } else {
            return defender.structureName + " withstands the attack!";
        }
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
}

// Main Program
public class MedievalKingdom {
    public static void main(String[] args) {
        WizardTower tower = new WizardTower();
        EnchantedCastle castle = new EnchantedCastle();
        MysticLibrary library = new MysticLibrary();
        DragonLair lair = new DragonLair("Ancient Lair", "Ice Dragon");

        MagicalStructure[] kingdom = {tower, castle, library, lair};

        for (MagicalStructure s : kingdom) {
            s.castMagicSpell();
        }

        System.out.println(KingdomManager.performMagicBattle(tower, lair));
        System.out.println("Total Kingdom Magic Power: " + KingdomManager.calculateKingdomMagicPower(kingdom));
    }
}
