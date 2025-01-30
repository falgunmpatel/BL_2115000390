import java.util.Scanner;

public class ReverseString {

    public static String reverse(String input) {
        char[] reversed = new char[input.length()];
        int index = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed[index++] = input.charAt(i);
        }

        return new String(reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        System.out.println("Reversed String: " + reverse(input));
    }
}
