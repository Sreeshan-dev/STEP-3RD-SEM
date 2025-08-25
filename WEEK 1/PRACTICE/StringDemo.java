public class StringDemo {
    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = new String("World");
        char[] charArray = {'J', 'a', 'v', 'a'};
        String str3 = new String(charArray);
        StringBuilder sb = new StringBuilder("StringBuilder Example");
        StringBuffer sBuf = new StringBuffer("StringBuffer Example");

        System.out.println("String literal: " + str1);
        System.out.println("Using new keyword: " + str2);
        System.out.println("From char array: " + str3);
        System.out.println("StringBuilder: " + sb);
        System.out.println("StringBuffer: " + sBuf);

        System.out.println("\n--- Basic String Manipulation ---");

        String concatStr = str1 + " " + str2;
        System.out.println("Concatenation: " + concatStr);
        System.out.println("Using concat(): " + str1.concat(" ").concat(str2));
        System.out.println("Substring (0 to 4): " + concatStr.substring(0, 5));
        System.out.println("Replace 'World' with 'Java': " + concatStr.replace("World", "Java"));
        System.out.println("Uppercase: " + concatStr.toUpperCase());
        System.out.println("Lowercase: " + concatStr.toLowerCase());

        String strWithSpaces = " Trim Example ";
        System.out.println("Before trim: '" + strWithSpaces + "'");
        System.out.println("After trim: '" + strWithSpaces.trim() + "'");
        System.out.println("Length of '" + concatStr + "' : " + concatStr.length());
    }
}

