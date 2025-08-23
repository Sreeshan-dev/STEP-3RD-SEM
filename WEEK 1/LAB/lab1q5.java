import java.util.Scanner;


public class lab1q5 {
    static String checkChar(char ch) {
        ch = Character.toLowerCase(ch);
        if ((ch >= 'a' && ch <= 'z')) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }


    static int[] countVowelsConsonants(String str) {
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            String result = checkChar(str.charAt(i));
            if (result.equals("Vowel")) {
                count[0]++;
            } else if (result.equals("Consonant")) {
                count[1]++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
       
        int[] result = countVowelsConsonants(input);
        System.out.println("Number of vowels: " + result[0]);
        System.out.println("Number of consonants: " + result[1]);
       
        scanner.close();
    }
}

