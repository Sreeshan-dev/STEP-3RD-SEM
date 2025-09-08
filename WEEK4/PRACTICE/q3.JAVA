public class GameController {
    String brand;
    String connection;
    boolean vibration;
    int battery;
    double sensitivity;

    public GameController() {
        brand = "GenericPad";
        connection = "USB";
        vibration = true;
        battery = 100;
        sensitivity = 1.0;
    }

    public GameController(String brand, String connection, boolean vibration, int battery, double sensitivity) {
        this.brand = brand;
        this.connection = connection;
        this.vibration = vibration;
        this.battery = battery;
        this.sensitivity = sensitivity;
    }

    public GameController(String brand, String connection) {
        this(brand, connection, true, 100, 1.0);
    }

    public void display() {
        System.out.println(brand + " | " + connection + " | Vibration:" + vibration + " | Battery:" + battery + "% | Sensitivity:" + sensitivity);
    }

    public static void main(String[] args) {
        GameController g1 = new GameController();
        GameController g2 = new GameController("Xbox", "Wireless", true, 80, 2.0);
        GameController g3 = new GameController("PS", "Bluetooth");
        g1.display();
        g2.display();
        g3.display();
    }
}
