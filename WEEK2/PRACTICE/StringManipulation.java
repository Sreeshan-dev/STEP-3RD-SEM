import java.util.*;
 
public class StringManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
 
        String trimmed = input.trim();
        String replaced = trimmed.replace(" ", "_");
        String noDigits = replaced.replaceAll("\\d", "");
        String[] words = noDigits.split("_");
        String joined = String.join(" | ", words);
 
        System.out.println("Trimmed: " + trimmed);
        System.out.println("Spaces replaced: " + replaced);
        System.out.println("Digits removed: " + noDigits);
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Joined: " + joined);
 
        System.out.println("No punctuation: " + removePunctuation(trimmed));
        System.out.println("Capitalized: " + capitalizeWords(trimmed));
        System.out.println("Reversed order: " + reverseWordOrder(trimmed));
        countWordFrequency(trimmed);
        sc.close();
	}
 
    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
	}
 
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
              .append(w.substring(1).toLowerCase()).append(" ");
        }
        return sb.toString().trim();
	}
 
    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
	}
 
    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        System.out.println("Word Frequencies: " + freq);
	}
}

