import java.util.*;
public class NumberChecker1 {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static boolean isDuckNumber(int number) {
        String numStr = String.valueOf(number);
        return numStr.contains("0") && !numStr.startsWith("0");
    }

    public static boolean isArmstrongNumber(int number) {
        String numStr = String.valueOf(number);
        int sum = 0;
        for (char c : numStr.toCharArray()) {
            sum += Math.pow(c - '0', numStr.length());
        }
        return sum == number;
    }

    public static void main(String[] args) {
        int number = (int)(Math.random() * 9000) + 1000;
        System.out.println("Number: " + number);
        System.out.println("Digits: " + countDigits(number));
        System.out.println("Duck: " + isDuckNumber(number));
        System.out.println("Armstrong: " + isArmstrongNumber(number));
    }
}
