import java.util.Scanner;
public class MostFrequentCharacter {

    public static char mostFrequentCharacter(String input) {
        int[] freq = new int[256]; // Assuming ASCII characters
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }

        int maxFreq = 0;
        char mostFrequent = '\0';
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (freq[ch] > maxFreq) {
                maxFreq = freq[ch];
                mostFrequent = ch;
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        System.out.println("Most Frequent Character: " + mostFrequentCharacter(input));
    }
}
