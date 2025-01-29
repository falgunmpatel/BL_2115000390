import java.util.Scanner;

public class ToggleCase {
    public static String toggleCase(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        StringBuilder toggled = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                toggled.append(Character.toLowerCase(ch));
            } else {
                toggled.append(Character.toUpperCase(ch));
            }
        }
        return toggled.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            System.out.println("Toggled Case: " + toggleCase(input));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
