import java.util.*;

public class ManualReplace {

    public static ArrayList<Integer> findOccurrences(String text, String find) {
        ArrayList<Integer> positions = new ArrayList<>();
        int index = text.indexOf(find);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(find, index + find.length()); 
        }
        return positions;
    }

    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareWithBuiltIn(String text, String find, String replace, String manualResult) {
        String builtInResult = text.replace(find, replace);
        return manualResult.equals(builtInResult);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main text: ");
        String text = sc.nextLine();

        System.out.print("Enter the substring to find: ");
        String find = sc.nextLine();

        System.out.print("Enter the substring to replace with: ");
        String replace = sc.nextLine();

        ArrayList<Integer> occurrences = findOccurrences(text, find);
        System.out.println("Occurrences found at positions: " + occurrences);

        String manualResult = manualReplace(text, find, replace);
        System.out.println("Manual Replace Result: " + manualResult);

        String builtInResult = text.replace(find, replace);
        System.out.println("Built-in Replace Result: " + builtInResult);

        boolean isSame = compareWithBuiltIn(text, find, replace, manualResult);
        System.out.println("Do both results match? " + isSame);

        sc.close();
    }
}
