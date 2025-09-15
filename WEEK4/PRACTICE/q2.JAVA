public class AudioMixer {
    String model;
    int channels;
    boolean bluetooth;
    double volume;
    String[] devices;
    int count;

    public AudioMixer() {
        this("StandardMix-8", 8, false, 123.0);
    }

    public AudioMixer(String model, int channels) {
        this(model, channels, false, 120.0);
    }

    public AudioMixer(String model, int channels, boolean bluetooth) {
        this(model, channels, bluetooth, 120.0);
    }

    public AudioMixer(String model, int channels, boolean bluetooth, double volume) {
        this.model = model;
        this.channels = channels;
        this.bluetooth = bluetooth;
        this.volume = volume;
        devices = new String[channels];
        count = 0;
    }

    public void connect(String d) {
        if (count < devices.length) devices[count++] = d;
    }

    public void show() {
        System.out.println(model + " | Channels:" + channels + " | BT:" + bluetooth + " | Vol:" + volume);
        for (int i = 0; i < count; i++) System.out.println(" - " + devices[i]);
    }

    public static void main(String[] args) {
        AudioMixer m1 = new AudioMixer();
        AudioMixer m2 = new AudioMixer("ProMix", 12);
        AudioMixer m3 = new AudioMixer("DJMix", 6, true);
        AudioMixer m4 = new AudioMixer("UltraMix", 16, true, 150.0);
        m1.connect("Mic"); m2.connect("Guitar"); m3.connect("Laptop"); m4.connect("Drums");
        m1.show(); m2.show(); m3.show(); m4.show();
    }
}
