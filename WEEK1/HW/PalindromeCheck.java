import java.util.*;
 
public class PalindromeCheck {
    public static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start++) != text.charAt(end--)) return false;
        }
        return true;
	}
 
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
	}
 
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new StringBuilder(text).reverse().toString().toCharArray();
        return Arrays.equals(original, reversed);
	}
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
 
        System.out.println("Iterative: " + isPalindromeIterative(text));
        System.out.println("Recursive: " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Array Compare: " + isPalindromeArray(text));
        sc.close();
	}
}
 

