public class Counter {
    static int count = 0;

    public Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        new Counter();
        new Counter();
        new Counter();
        System.out.println("Objects created: " + Counter.getCount());
    }
}
