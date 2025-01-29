import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int low = 1, high = 100, guess;
        String response;

        System.out.println("Think of a number between 1 and 100. I'll try to guess it!");

        while (low <= high) {
            guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");

            try {
                response = scanner.next().toLowerCase();
                if (response.equals("correct")) {
                    System.out.println("Yay! I guessed it!");
                    break;
                } else if (response.equals("high")) {
                    high = guess - 1;
                } else if (response.equals("low")) {
                    low = guess + 1;
                } else {
                    throw new IllegalArgumentException("Invalid response. Please enter 'high', 'low', or 'correct'.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
