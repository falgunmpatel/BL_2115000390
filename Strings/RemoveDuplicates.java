import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        Set<Character> seen = new LinkedHashSet<>();
        for (char ch : input.toCharArray()) {
            seen.add(ch);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : seen) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            System.out.println("String without duplicates: " + removeDuplicates(input));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
