public class StringPerformanceComparison {
    public static void main(String[] args) {
        long start, end;
 
        start = System.nanoTime();
        concatenateWithString(1000);
        end = System.nanoTime();
        System.out.println("String time: " + (end - start) + " ns");
 
        start = System.nanoTime();
        concatenateWithStringBuilder(1000);
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");
 
        start = System.nanoTime();
        concatenateWithStringBuffer(1000);
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");
 
        demonstrateStringBuilderMethods();
	}
 
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java " + i + " ";
        }
        return result;
	}
 
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
	}
 
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java ").append(i).append(" ");
        }
        return sb.toString();
	}
 
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        sb.append("!!!");
        sb.insert(6, "Java ");
        sb.delete(0, 5);
        sb.deleteCharAt(0);
        sb.reverse();
        sb.replace(0, 4, "Test");
        sb.setCharAt(0, 'X');
        System.out.println("Final SB: " + sb);
        System.out.println("Capacity: " + sb.capacity());
        sb.ensureCapacity(100);
        sb.trimToSize();
	}
}
