import java.util.*;
public class StudentMarksCalculator {
    public static int[][] generateRandomMarks(int students) {
        int[][] marks = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) marks[i][j] = (int)(Math.random() * 91) + 10;
        }
        return marks;
    }

    public static double[] calculateResults(int[] marks) {
        double total = 0;
        for (int mark : marks) total += mark;
        double average = total / marks.length;
        double percentage = (total / 300) * 100;
        return new double[]{total, average, percentage};
    }

    public static void displayResults(int[][] marks) {
        System.out.println("Physics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int[] studentMarks : marks) {
            double[] results = calculateResults(studentMarks);
            System.out.println(studentMarks[0] + "\t" + studentMarks[1] + "\t" + studentMarks[2] + "\t" + results[0] + "\t" + results[1] + "\t" + results[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();
        int[][] marks = generateRandomMarks(students);
        displayResults(marks);
    }
}
