import java.util.*;

public class MostFrequentCharacter {
    public static char mostFrequentCharacter(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty.");
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        return Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            System.out.println("Most Frequent Character: " + mostFrequentCharacter(input));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
