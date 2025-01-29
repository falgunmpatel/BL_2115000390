import java.util.Scanner;

public class PalindromeCheck {
    public static boolean isPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        input = input.toLowerCase();
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            System.out.println("Is Palindrome: " + isPalindrome(input));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
