import java.util.*;  
class LargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter three numbers:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

        System.out.println("Is the first number the largest? " + (num1 > num2 && num1 > num3));
        System.out.println("Is the second number the largest? " + (num2 > num1 && num2 > num3));
        System.out.println("Is the third number the largest? " + (num3 > num1 && num3 > num2));
    }
}


