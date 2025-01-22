import java.util.*;  
class CountdownWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the starting value for countdown:");
        int counter = input.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Launch!");
    }
}


