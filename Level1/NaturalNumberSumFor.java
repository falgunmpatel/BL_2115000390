import java.util.*;  
class NaturalNumberSumFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();

        if (number >= 0) {
            int sumFormula = number * (number + 1) / 2;
            int sumLoop = 0;

            for (int i = 1; i <= number; i++) {
                sumLoop += i;
            }

            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using loop: " + sumLoop);
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }
    }
}


