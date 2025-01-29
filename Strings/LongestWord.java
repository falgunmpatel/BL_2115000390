import java.util.Scanner;

public class LongestWord {
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be empty.");
        }

        String[] words = sentence.split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a sentence:");
            String input = scanner.nextLine();
            System.out.println("Longest Word: " + findLongestWord(input));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
