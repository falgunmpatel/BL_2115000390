
import java.util.*;
class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int digitCount = 0;

        while (number != 0) {
            number /= 10;
            digitCount++;
        }

        System.out.println("Number of digits: " + digitCount);
    }
}
