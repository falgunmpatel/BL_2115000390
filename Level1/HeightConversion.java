import java.util.Scanner;
class HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in cm: ");
        double heightCm = input.nextDouble();

        double heightInInches = heightCm / 2.54;
        int heightInFeet = (int) (heightInInches / 12);
        double remainingInches = heightInInches % 12;

        System.out.println("Your height in cm is " + heightCm + 
                           " while in feet is " + heightInFeet + 
                           " and inches is " + remainingInches + ".");
    }
}
