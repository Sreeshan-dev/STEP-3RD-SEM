import java.util.Scanner;


public class lab1q3 {
    public static String[] splitIntoWords(String text) {
        String word = "";
        int wordCount = 0;
        String[] words = new String[100];
       
        for (int i = 0; text.charAt(i) != '\0'; i++) {
            if (text.charAt(i) == ' ') {
                if (!word.equals("")) {
                    words[wordCount++] = word;
                    word = "";
                }
            } else {
                word += text.charAt(i);
            }
        }
        if (!word.equals("")) {
            words[wordCount++] = word;
        }
       
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            result[i] = words[i];
        }
        return result;
    }


    public static int findLength(String str) {
        int length = 0;
        try {
            while (str.charAt(length) != '\0') {
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return length;
        }
        return length;
    }


    public static String[][] createWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
       
        String[] words = splitIntoWords(text);
        String[][] wordLengths = createWordLengthArray(words);
       
        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (String[] wordLength : wordLengths) {
            System.out.println(wordLength[0] + "\t" + Integer.parseInt(wordLength[1]));
        }
       
        scanner.close();
    }
}

