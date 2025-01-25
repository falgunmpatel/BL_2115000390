import java.util.Scanner;
class MeanHeight{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] heights = new double[11];
        double total = 0.0;
        
        System.out.println("Enter the heights of 11 players: ");
        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
            total += heights[i];
        }

        double mean = total / 11;
        System.out.println("The mean height of the football team is: "+ mean);

    }
}
