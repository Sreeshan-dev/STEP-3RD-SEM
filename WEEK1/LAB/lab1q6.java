import java.util.Scanner;


public class lab1q6 {
    static String checkChar(char ch) {
        ch = Character.toLowerCase(ch);
        if (!Character.isLetter(ch)) {
            return "Not a Letter";
        }
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }
        return "Consonant";
    }


    static String[][] findVowelsConsonants(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = checkChar(str.charAt(i));
        }
        return result;
    }


    static void displayResult(String[][] arr) {
        System.out.println("Character\tType");
        System.out.println("-------------------");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String[][] result = findVowelsConsonants(input);
        displayResult(result);
        scanner.close();
    }
}

