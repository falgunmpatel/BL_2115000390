import java.util.*;

public class AnagramCheck {
    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Neither string can be null.");
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter first string:");
            String str1 = scanner.nextLine();
            System.out.println("Enter second string:");
            String str2 = scanner.nextLine();
            System.out.println("Are they anagrams? " + areAnagrams(str1, str2));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
