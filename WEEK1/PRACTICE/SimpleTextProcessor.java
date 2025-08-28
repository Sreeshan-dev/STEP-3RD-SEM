import java.util.Scanner;

public class SimpleTextProcessor {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
String[] lines = new String[5]; // Store up to 5 lines of text
int count = 0;

System.out.println("=== Simple Text Processor ===");

// Input text
while (count < lines.length) {
System.out.print("Enter a line of text (or 'stop' to finish): ");
String input = sc.nextLine();
if (input.equalsIgnoreCase("stop")) break;
lines[count] = input;
count++;
}

// Menu-driven processing
int choice;
do {
System.out.println("\n--- Menu ---");
System.out.println("1. Display All Lines");
System.out.println("2. Convert to Uppercase");
System.out.println("3. Convert to Lowercase");
System.out.println("4. Search for a Word");
System.out.println("5. Replace a Word");
System.out.println("6. Trim All Lines");
System.out.println("7. Show Length of Each Line");
System.out.println("8. Exit");

System.out.print("Enter your choice: ");
choice = sc.nextInt();
sc.nextLine(); // Clear buffer

switch (choice) {
case 1:
displayLines(lines, count);
break;
case 2:
convertCase(lines, count, true);
break;
case 3:
convertCase(lines, count, false);
break;
case 4:
searchWord(lines, count, sc);
break;
case 5:
replaceWord(lines, count, sc);
break;
case 6:
trimLines(lines, count);
break;
case 7:
showLengths(lines, count);
break;
case 8:
System.out.println("Exiting... Goodbye!");
break;
default:
System.out.println("Invalid choice!");

}
} while (choice != 8);

sc.close();
}

// Display lines
public static void displayLines(String[] arr, int count) {
if (count == 0) {
System.out.println("No text stored.");
return;
}
System.out.println("Stored Text:");
for (int i = 0; i < count; i++) {
System.out.println((i + 1) + ": " + arr[i]);
}
}

// Convert case
public static void convertCase(String[] arr, int count, boolean upper) {
for (int i = 0; i < count; i++) {
arr[i] = upper ? arr[i].toUpperCase() : arr[i].toLowerCase();
}
System.out.println("Case converted successfully.");
}

// Search word
public static void searchWord(String[] arr, int count, Scanner sc) {
System.out.print("Enter word to search: ");
String word = sc.nextLine();
boolean found = false;

for (int i = 0; i < count; i++) {
if (arr[i].toLowerCase().contains(word.toLowerCase())) {
System.out.println("Found in line " + (i + 1) + ": " + arr[i]);
found = true;
}
}
if (!found) {
System.out.println("Word not found.");
}
}

// Replace word
public static void replaceWord(String[] arr, int count, Scanner sc) {
System.out.print("Enter word to replace: ");
String oldWord = sc.nextLine();
System.out.print("Enter new word: ");
String newWord = sc.nextLine();
for (int i = 0; i < count; i++) {
arr[i] = arr[i].replace(oldWord, newWord);
}
System.out.println("Replacement done.");
}

// Trim lines
public static void trimLines(String[] arr, int count) {
for (int i = 0; i < count; i++) {
arr[i] = arr[i].trim();
}
System.out.println("All lines trimmed.");
}

// Show lengths
public static void showLengths(String[] arr, int count) {
for (int i = 0; i < count; i++) {
System.out.println("Line " + (i + 1) + " length: " + arr[i].length());
}
}
}