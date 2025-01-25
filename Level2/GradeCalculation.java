import java.util.Scanner;

public class GradeCalculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();

        int[] physics = new int[numStudents];
        int[] chemistry = new int[numStudents];
        int[] maths = new int[numStudents];
        double[] percentage = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            physics[i] = input.nextInt();
            if (physics[i] < 0) {
                System.out.println("Marks cannot be negative. Enter positive value.");
                i--;
                continue;
            }

            System.out.print("Chemistry: ");
            chemistry[i] = input.nextInt();
            if (chemistry[i] < 0) {
                System.out.println("Marks cannot be negative. Enter positive value.");
                i--;
                continue;
            }

            System.out.print("Maths: ");
            maths[i] = input.nextInt();
            if (maths[i] < 0) {
                System.out.println("Marks cannot be negative. Enter positive value.");
                i--;
                continue;
            }

            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
        }

        for (int i = 0; i < numStudents; i++) {
            if (percentage[i] >= 80) {
                System.out.println("Percentage calculated: " + percentage[i] +
                                   " Level: 4 and Remark: Above agency-normalized standards");
            } else if (percentage[i] >= 70 && percentage[i] <= 79) {
                System.out.println("Percentage calculated: " + percentage[i] +
                                   " Level: 3 and Remark: at agency-normalized standards");
            } else if (percentage[i] >= 60 && percentage[i] <= 69) {
                System.out.println("Percentage calculated: " + percentage[i] +
                                   " Level: 2 and Remark: Below but approaching agency-normalized standards");
            } else if (percentage[i] >= 50 && percentage[i] <= 59) {
                System.out.println("Percentage calculated: " + percentage[i] +
                                   " Level: 1 and Remark: well below agency-normalized standards");
            } else if (percentage[i] >= 40 && percentage[i] <= 49) {
                System.out.println("Percentage calculated: " + percentage[i] +
                                   " Level: 1- and Remark: too below agency-normalized standards");
            } else {
                System.out.println("Percentage calculated: " + percentage[i] +
                                   " Level: 4 and Remark: remedial standards");
            }
        }
    }
}
