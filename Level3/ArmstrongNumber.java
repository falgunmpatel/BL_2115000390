import java.util.*;
class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int originalNumber = number;
        int sumOfCubes = 0;

        while (number != 0) {
            int digit = number % 10;
            sumOfCubes += digit * digit * digit;
            number /= 10;
        }

        if (sumOfCubes == originalNumber) {
            System.out.println(originalNumber + " is an Armstrong number");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number");
        }
    }
}
