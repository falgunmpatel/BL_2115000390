import java.util.*;
class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double first = input.nextDouble();
        double second = input.nextDouble();
        String operator = input.next();

        double result = 0;

        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        System.out.println("Result: " + result);
    }
}
