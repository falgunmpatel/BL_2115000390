import java.util.*;
class VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the 10 Elements of array: ");	
        int Age[] = new int[10];
        for (int i = 0; i < 10; i++){
            Age[i] = input.nextInt();
        }
        
        for(int i = 0; i < 10; i++) {
            if(Age[i]  <=  0){
                System.out.println("Invalid Age");
	            System.exit(0);
            } else if(Age[i] >=  18) {
                System.out.println("The student with the age " + Age[i] +" can vote");
            } else {
                System.out.println("The student with the age " + Age[i] +" can not vote");
            }
        }
    }
}
