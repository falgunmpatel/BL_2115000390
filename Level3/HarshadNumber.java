
import java.util.Scanner;
class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int temp = number;
        int digitSum = 0;

        while (temp != 0) {
            digitSum += temp % 10;
            temp /= 10;
        }

        if (number % digitSum == 0) {
            System.out.println(number + " is a Harshad number");
        } else {
            System.out.println(number + " is not a Harshad number");
        }
    }
}
