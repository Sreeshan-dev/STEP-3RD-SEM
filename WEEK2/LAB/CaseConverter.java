import java.util.Scanner; 
 
public class CaseConverter { 
    public static char toUpperCase(char ch) { 
        if (ch >= 'a' && ch <= 'z') { 
            return (char)(ch - 32); 
        } 
        return ch; 
    } 
 
    
    public static char toLowerCase(char ch) { 
        if (ch >= 'A' && ch <= 'Z') { 
            return (char)(ch + 32); 
        } 
        return ch; 
    } 
 
  
    public static String convertToUpperCase(String str) { 
        StringBuilder result = new StringBuilder(); 
        for (char ch : str.toCharArray()) { 
            result.append(toUpperCase(ch)); 
        } 
        return result.toString(); 
    } 
 
 
    public static String convertToLowerCase(String str) { 
        StringBuilder result = new StringBuilder(); 
        for (char ch : str.toCharArray()) { 
            result.append(toLowerCase(ch)); 
        } 
        return result.toString(); 
    } 
 
  
    public static String convertToTitleCase(String str) { 
        StringBuilder result = new StringBuilder(); 
        boolean newWord = true; 
 
        for (char ch : str.toCharArray()) { 
            if (ch == ' ') { 
                newWord = true; 
                result.append(ch); 
            } else { 
                if (newWord) { 
                    result.append(toUpperCase(ch)); 
                    newWord = false; 
                } else { 
                    result.append(toLowerCase(ch)); 
                } 
            } 
        } 
 
        return result.toString(); 
    } 
 
    
    public static void printComparison(String input) { 
        String asciiUpper = convertToUpperCase(input); 
        String asciiLower = convertToLowerCase(input); 
        String asciiTitle = convertToTitleCase(input); 
 
        String builtInUpper = input.toUpperCase(); 
        String builtInLower = input.toLowerCase(); 
        String builtInTitle = builtInTitleCase(input); 
 
        System.out.printf("%-20s | %-30s | %-30s%n", "Conversion", "ASCII Method", "Built-in Method"); 
        System.out.printf("%-20s | %-30s | %-30s%n", "Uppercase", 
asciiUpper, builtInUpper); 
        System.out.printf("%-20s | %-30s | %-30s%n", "Lowercase", 
asciiLower, builtInLower); 
        System.out.printf("%-20s | %-30s | %-30s%n", "Title Case", 
asciiTitle, builtInTitle); 
    } 
 
 
    public static String builtInTitleCase(String str) { 
        StringBuilder result = new StringBuilder(); 
        boolean newWord = true; 
 
        for (char ch : str.toCharArray()) { 
            if (ch == ' ') { 
                newWord = true; 
                result.append(ch); 
            } else { 
                if (newWord) { 
                    result.append(Character.toUpperCase(ch)); 
                    newWord = false; 
                } else { 
                    result.append(Character.toLowerCase(ch)); 
                } 
            } 
        } 
 
        return result.toString(); 
    } 
 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter a line of text:"); 
        String input = scanner.nextLine(); 
 
        printComparison(input); 
        scanner.close(); 
    } 
} 

