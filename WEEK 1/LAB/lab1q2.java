import java.util.Scanner;


public class lab1q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
       
        String[] builtInSplit = text.split(" ");
        String[] customSplit = splitText(text);
       
        boolean areEqual = compareArrays(builtInSplit, customSplit);
       
        System.out.println("Built-in split result:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }
       
        System.out.println("\nCustom split result:");
        for (String word : customSplit) {
            System.out.println(word);
        }
       
        System.out.println("\nArrays are equal: " + areEqual);
        scanner.close();
    }


    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }


    public static String[] splitText(String text) {
        int length = findLength(text);
        int spaceCount = 0;
       
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
       
        int[] spaceIndexes = new int[spaceCount + 2];
        int j = 1;
        spaceIndexes[0] = -1;
       
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[j] = i;
                j++;
            }
        }
        spaceIndexes[spaceCount + 1] = length;
       
        String[] words = new String[spaceCount + 1];
       
        for (int i = 0; i < spaceCount + 1; i++) {
            words[i] = text.substring(spaceIndexes[i] + 1, spaceIndexes[i + 1]);
        }
       
        return words;
    }


    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
       
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
       
        return true;
    }
}

