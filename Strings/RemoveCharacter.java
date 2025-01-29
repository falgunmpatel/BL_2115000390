import java.util.Scanner;

public class RemoveCharacter {
    public static String removeCharacter(String input, char characterToRemove) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        return input.replaceAll(Character.toString(characterToRemove), "");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            System.out.println("Enter the character to remove:");
            char characterToRemove = scanner.next().charAt(0);
            System.out.println("Modified String: " + removeCharacter(input, characterToRemove));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
