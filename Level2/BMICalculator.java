import java.util.Scanner;

class BMICalculator {

   public static double calculateBMI(double weight, double heightInCm) {
      double heightInMeters = heightInCm / 100;
      return weight / (heightInMeters * heightInMeters);
   }

   public static String determineBMIStatus(double bmi) {
      if (bmi < 18.5) {
         return "Underweight";
      } else if (bmi >= 18.5 && bmi < 24.9) {
         return "Normal weight";
      } else if (bmi >= 25 && bmi < 29.9) {
         return "Overweight";
      } else {
         return "Obesity";
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double[][] bmiData = new double[10][3];

      for (int i = 0; i < 10; i++) {
         System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
         double weight = scanner.nextDouble();
         System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
         double height = scanner.nextDouble();

         double bmi = calculateBMI(weight, height);
         bmiData[i][0] = weight;
         bmiData[i][1] = height;
         bmiData[i][2] = bmi;

         System.out.println("BMI for person " + (i + 1) + ": " + bmi);
         System.out.println("BMI Status: " + determineBMIStatus(bmi));
      }
   }
}
