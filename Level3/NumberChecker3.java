import java.util.*;
public class NumberChecker3 {
    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }

    public static boolean isPalindrome(int number) {
        return number == reverseNumber(number);
    }

    public static void main(String[] args) {
        int number = (int)(Math.random() * 9000) + 1000;
        System.out.println("Number: " + number);
        System.out.println("Reversed: " + reverseNumber(number));
        System.out.println("Palindrome: " + isPalindrome(number));
    }
}
