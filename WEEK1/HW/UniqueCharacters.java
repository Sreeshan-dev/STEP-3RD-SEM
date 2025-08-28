import java.util.*;
 
public class UniqueCharacters {
    public static char[] findUnique(String text) {
        char[] result = new char[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                	isUnique = false;
                	break;
                }
            }
            if (isUnique) result[count++] = c;
        }
        return Arrays.copyOf(result, count);
	}
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        char[] unique = findUnique(text);
        System.out.println("Unique characters: " + Arrays.toString(unique));
        sc.close();
	}
}

