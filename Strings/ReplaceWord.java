import java.util.Scanner;

public class ReplaceWord {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        if (sentence == null || oldWord == null || newWord == null) {
            throw new IllegalArgumentException("Input strings cannot be null.");
        }

        return sentence.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a sentence:");
            String sentence = scanner.nextLine();
            System.out.println("Enter the word to replace:");
            String oldWord = scanner.nextLine();
            System.out.println("Enter the new word:");
            String newWord = scanner.nextLine();
            System.out.println("Modified Sentence: " + replaceWord(sentence, oldWord, newWord));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
