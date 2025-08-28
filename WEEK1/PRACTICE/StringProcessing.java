import java.util.Scanner;

public class StringProcessing {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

// Taking user input
System.out.print("Enter a string: ");

String input = sc.nextLine();

System.out.println("\n--- String Processing ---");

// Length of string
System.out.println("Length: " + input.length());

// Uppercase & Lowercase
System.out.println("Uppercase: " + input.toUpperCase());
System.out.println("Lowercase: " + input.toLowerCase());

// First and last character
if (input.length() > 0) {
System.out.println("First character: " + input.charAt(0));
System.out.println("Last character: " + input.charAt(input.length() - 1));
}

// Substring example
if (input.length() >= 3) {
System.out.println("First 3 characters: " + input.substring(0, 3));
}

// Replace example
System.out.println("Replace 'a' with '@': " + input.replace('a', '@'));

// Trim spaces
System.out.println("Trimmed: '" + input.trim() + "'");

// Contains example
System.out.println("Contains 'Java'? " + input.contains("Java"));

// EqualsIgnoreCase example
System.out.println("Equals 'hello' (ignore case)? " + input.equalsIgnoreCase("hello"));

sc.close();
}
}
