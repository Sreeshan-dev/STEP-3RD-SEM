import java.util.Scanner;


public class lab1q4 {
    public static String[] splitText(String text) {
        int count = 1;
        for (int i = 0; i < getLength(text); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
       
        String[] words = new String[count];
        String word = "";
        int index = 0;
       
        for (int i = 0; i < getLength(text); i++) {
            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                words[index] = word;
                word = "";
                index++;
            }
        }
        words[index] = word;
        return words;
    }
   
    public static int getLength(String str) {
        int length = 0;
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
            return length;
        }
    }
   
    public static String[][] getWordLengths(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i][0] = words[i];
            wordLengths[i][1] = String.valueOf(getLength(words[i]));
        }
        return wordLengths;
    }
   
    public static int[] findMinMax(String[][] wordLengths) {
        int min = Integer.parseInt(wordLengths[0][1]);
        int max = Integer.parseInt(wordLengths[0][1]);
       
        for (int i = 1; i < wordLengths.length; i++) {
            int currentLength = Integer.parseInt(wordLengths[i][1]);
            if (currentLength < min) {
                min = currentLength;
            }
            if (currentLength > max) {
                max = currentLength;
            }
        }
        return new int[]{min, max};
    }
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
       
        String[] words = splitText(text);
        String[][] wordLengths = getWordLengths(words);
        int[] minMax = findMinMax(wordLengths);
       
        System.out.println("Shortest word length: " + minMax[0]);
        System.out.println("Longest word length: " + minMax[1]);
       
        scanner.close();
    }
}
