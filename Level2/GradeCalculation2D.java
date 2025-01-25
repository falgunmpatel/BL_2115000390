import java.util.*;

public class GradeCalculation2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int number = input.nextInt();

        double[][] marks = new double[number][3];
        double[] percentage = new double[number];

        for (int i = 0; i < number; i++) {
            double sum = 0;
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter mark " + (j + 1) + ": ");
                marks[i][j] = input.nextInt();
                sum += marks[i][j];
            }
            percentage[i] = sum / 3;
        }

        for (int i = 0; i < number; i++) {
            System.out.print("Percentage calculated: " + percentage[i] + " ");

            if (percentage[i] >= 80) {
                System.out.println("Level: 4 and Remark: Above agency-normalized standards");
            } else if (percentage[i] >= 70 && percentage[i] <= 79) {
                System.out.println("Level: 3 and Remark: at agency-normalized standards");
            } else if (percentage[i] >= 60 && percentage[i] <= 69) {
                System.out.println("Level: 2 and Remark: Below but approaching agency-normalized standards");
            } else if (percentage[i] >= 50 && percentage[i] <= 59) {
                System.out.println("Level: 1 and Remark: well below agency-normalized standards");
            } else if (percentage[i] >= 40 && percentage[i] <= 49) {
                System.out.println("Level: 1- and Remark: too below agency-normalized standards");
            } else {
                System.out.println("Level: 4 and Remark: remedial standards");
            }
        }
    }
}
