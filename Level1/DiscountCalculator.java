import java.util.Scanner;
class DiscountCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the fee amount: ");
        double fee = input.nextDouble();

        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();

        double discountAmount = (discountPercent / 100) * fee;
        double discountedFee = fee - discountAmount;

        System.out.println("The discount amount is INR " + discountAmount + 
                           " and final discounted fee is INR " + discountedFee + ".");
    }
}
