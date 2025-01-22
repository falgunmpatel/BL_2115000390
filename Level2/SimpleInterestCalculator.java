import java.util.Scanner;
class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the Rate of Interest (in %): ");
        double rate = input.nextDouble();

        System.out.print("Enter the Time (in years): ");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + 
                           principal + ", Rate of Interest " + rate + "% and Time " + time + " years.");
    }
}
