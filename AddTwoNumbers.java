import java.util.*;
public class AddTwoNumbers {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = a + b;
		System.out.println("Sum of two numbers: " + sum);
	}
}
