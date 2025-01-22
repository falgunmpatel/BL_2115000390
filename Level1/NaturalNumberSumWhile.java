import java.util.*;  
class NaturalNumberSumWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();

        if (number >= 0) {
            int sumFormula = number * (number + 1) / 2;
            int sumLoop = 0;
            int i = 1;

            while (i <= number) {
                sumLoop += i;
                i++;
            }

            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using loop: " + sumLoop);
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }
    }
}


