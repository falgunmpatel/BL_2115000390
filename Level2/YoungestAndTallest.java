import java.util.Scanner;

class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter age of %s: ", names[i]);
            ages[i] = input.nextInt();

            System.out.printf("Enter height of %s: ", names[i]);
            heights[i] = input.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        System.out.printf("Youngest: %s\n", names[youngestIndex]);
        System.out.printf("Tallest: %s\n", names[tallestIndex]);
    }
}
