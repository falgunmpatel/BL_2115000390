import java.util.Scanner;

public class CompareStrings {

    public static void compareStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            System.out.println("Neither string can be null.");
            return;
        }

        int length1 = str1.length();
        int length2 = str2.length();
        int minLength = Math.min(length1, length2);

        for (int i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 < ch2) {
                System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
                return;
            } else if (ch1 > ch2) {
                System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
                return;
            }
        }

        if (length1 == length2) {
            System.out.println("Both strings are equal.");
        } else if (length1 < length2) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
        } else {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string:");
        String str1 = scanner.nextLine();
        System.out.println("Enter second string:");
        String str2 = scanner.nextLine();
        compareStrings(str1, str2);
    }
}
