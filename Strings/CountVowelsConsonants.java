import java.util.Scanner;

public class CountVowelsConsonants {
    public static void countVowelsAndConsonants(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty.");
        }

        int vowels = 0, consonants = 0;
        input = input.toLowerCase();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            countVowelsAndConsonants(input);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
