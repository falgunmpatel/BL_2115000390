import java.util.*;  
class SumUntilZero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;

        while (true) {
            System.out.println("Enter a number (0 to stop):");
            double number = input.nextDouble();

            if (number == 0) {
                break;
            }

            total += number;
        }

        System.out.println("The total sum is: " + total);
    }
}


