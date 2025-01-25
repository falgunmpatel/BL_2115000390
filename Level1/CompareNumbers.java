import java.util.*;
class CompareNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number[] = new int[5];
        System.out.println("Enter the 5 Elements of array: ");
        for (int i = 0; i < 5; i++){
            number[i] = input.nextInt();
        }
        
        for(int i = 0; i < 5; i++){
            if(number[i]>0){
                if(number[i]%2 == 0){
                    System.out.println(number[i]+" is Even");
                } else {
                    System.out.println(number[i]+" is odd");
                }
            } else if(number[i] <  0){
                System.out.println(number[i]+" is Negative");
            } else{
                System.out.println(number[i]+" is zero");
            }
        }
        if(number[0] > number[4]) {
            System.out.println("First Number is greater than last");
        } else if (number[0] < number[4]) {
            System.out.println("First Number is less than last");
        } else {
            System.out.println("First Number is equal to last");
        }
    }
}
