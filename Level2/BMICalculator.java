import java.util.*;
class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight (in kg): ");
        double weight = input.nextDouble();
        System.out.print("Enter height (in cm): ");
        double heightCm = input.nextDouble();
        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);
        System.out.println("Your BMI is: " + bmi);
        if (bmi <= 18.4) {
            System.out.println("Weight status: Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Weight status: Normal");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Weight status: Overweight");
        } else {
            System.out.println("Weight status: Obese");
        }
    }
}
