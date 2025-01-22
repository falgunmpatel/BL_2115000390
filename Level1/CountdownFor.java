import java.util.*;  
class CountdownFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the starting value for countdown:");
        int counter = input.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Launch!");
    }
}
