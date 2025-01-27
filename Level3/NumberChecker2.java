import java.util.*;
public class NumberChecker2 {
  public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number) {
        return number % sumOfDigits(number) == 0;
    }

    public static int[] digitFrequency(int number) {
        int[] freq = new int[10];
        while (number > 0) {
            freq[number % 10]++;
            number /= 10;
        }
        return freq;
    }

    public static void main(String[] args) {
        int number = (int)(Math.random() * 9000) + 1000;
        System.out.println("Number: " + number);
        System.out.println("Harshad: " + isHarshadNumber(number));
        System.out.println("Frequency: " + Arrays.toString(digitFrequency(number)));
    }
}
