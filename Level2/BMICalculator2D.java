import java.util.Scanner;
public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            double weight, height;

            do {
                System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
                weight = input.nextDouble();
                if (weight <= 0) {
                    System.out.println("Please enter a positive value for weight.");
                }
            } while (weight <= 0);

            do {
                System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
                height = input.nextDouble();
                if (height <= 0) {
                    System.out.println("Please enter a positive value for height.");
                }
            } while (height <= 0);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] >= 25 && personData[i][2] <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson | Weight (kg) | Height (m) | BMI  | Status");
        for (int i = 0; i < n; i++) {
            System.out.printf("%5d | %12.2f | %11.2f | %.2f | %s\n", i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
