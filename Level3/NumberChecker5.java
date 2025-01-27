import java.util.*;
public class NumberChecker5 {
    public static List<Integer> findFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors.add(i);
        }
        return factors;
    }

    public static int sumOfFactors(List<Integer> factors) {
        return factors.stream().mapToInt(Integer::intValue).sum();
    }

    public static int productOfFactors(List<Integer> factors) {
        return factors.stream().reduce(1, (a, b) -> a * b);
    }

    public static boolean isPerfect(int number, int sumOfFactors) {
        return sumOfFactors - number == number;
    }

    public static boolean isAbundant(int number, int sumOfFactors) {
        return sumOfFactors - number > number;
    }

    public static boolean isDeficient(int number, int sumOfFactors) {
        return sumOfFactors - number < number;
    }

    public static void main(String[] args) {
        int number = (int)(Math.random() * 100) + 1;
        List<Integer> factors = findFactors(number);
        int sum = sumOfFactors(factors);
        System.out.println("Number: " + number);
        System.out.println("Factors: " + factors);
        System.out.println("Sum: " + sum);
        System.out.println("Perfect: " + isPerfect(number, sum));
        System.out.println("Abundant: " + isAbundant(number, sum));
        System.out.println("Deficient: " + isDeficient(number, sum));
    }
}
