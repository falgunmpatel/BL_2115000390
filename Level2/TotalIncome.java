import java.util.Scanner;
class TotalIncome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter the bonus: ");
        double bonus = input.nextDouble();

        double income = salary + bonus;

        System.out.println("The salary is INR " + salary + " and bonus is INR " + bonus + 
                           ". Hence Total Income is INR " + income + ".");
    }
}
