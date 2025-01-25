import java.util.Scanner;
class SumOfAllNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        while (true) {
            System.out.print("Enter a number : ");
            double num  = input.nextDouble();
            if (num <= 0) {
                break;
            }
            if (index == 10) {
                System.out.println("Array is full! Stop input.");
                break;
            }
            numbers[index] = num;
            index++;
        }

        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }
        
        System.out.println("Total of all numbers: " + total);
    }
}
