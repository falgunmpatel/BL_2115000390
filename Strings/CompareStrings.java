import java.util.Scanner;

public class CompareStrings {
    public static void compareStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Neither string can be null.");
        }

        int comparisonResult = str1.compareTo(str2);
        if (comparisonResult == 0) {
            System.out.println("Both strings are equal.");
        } else if (comparisonResult < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
        } else {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter first string:");
            String str1 = scanner.nextLine();
            System.out.println("Enter second string:");
            String str2 = scanner.nextLine();
            compareStrings(str1, str2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
