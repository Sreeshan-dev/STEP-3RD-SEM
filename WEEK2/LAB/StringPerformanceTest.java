import java.util.*;

public class StringPerformanceTest {

    public static long testStringConcat(int iterations) {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s += "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("String      | Time: " + (end - start) + " ms | Length: " + s.length());
        return end - start;
    }

    public static long testStringBuilder(int iterations) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder | Time: " + (end - start) + " ms | Length: " + sb.length());
        return end - start;
    }

    public static long testStringBuffer(int iterations) {
        long start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer  | Time: " + (end - start) + " ms | Length: " + sbf.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int iterations = sc.nextInt();

        System.out.println("\n--- Performance Analysis ---");
        long t1 = testStringConcat(iterations);
        long t2 = testStringBuilder(iterations);
        long t3 = testStringBuffer(iterations);

        System.out.println("\n--- Summary Table ---");
        System.out.println("Method         | Time (ms) ");
        System.out.println("-----------------------------");
        System.out.println("String         | " + t1);
        System.out.println("StringBuilder  | " + t2);
        System.out.println("StringBuffer   | " + t3);

        sc.close();
    }
}
