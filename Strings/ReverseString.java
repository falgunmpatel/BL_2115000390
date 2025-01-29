import java.util.Scanner;

public class ReverseString {
    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String cannot be null.");
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            System.out.println("Reversed String: " + reverse(input));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
