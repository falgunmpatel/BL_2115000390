import java.util.*;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int digitCount = 0;
        int original = number;

        while (number > 0) {
            digitCount++;
            number /= 10;
        }

        int[] digits = new int[10];

        for (int i = 0; i < digitCount; i++) {
            int digit = original % 10;
            digits[digit]++;
            original /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Frequency of digit " + i + " is " + digits[i]);
        }
    }
}

