import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int chocolates, int children) {
        return new int[] {chocolates / children, chocolates % children};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = scanner.nextInt();

        System.out.print("Enter number of children: ");
        int children = scanner.nextInt();

        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Chocolates per child: " + result[0] + ", Remaining chocolates: " + result[1]);
    }
}

