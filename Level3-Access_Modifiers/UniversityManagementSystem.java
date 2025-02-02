class Student {
   public int rollNumber;
   protected String name;
   private double CGPA;

   public Student(int rollNumber, String name, double CGPA) {
       this.rollNumber = rollNumber;
       this.name = name;
       this.CGPA = CGPA;
   }

   public double getCGPA() {
       return CGPA;
   }

   public void setCGPA(double CGPA) {
       this.CGPA = CGPA;
   }
}

class PostgraduateStudent extends Student {
   public String researchTopic;

   public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
       super(rollNumber, name, CGPA);
       this.researchTopic = researchTopic;
   }

   public void displayDetails() {
        System.out.println("*************************");
         System.out.println();

         System.out.println("Roll Number: " + rollNumber);
         System.out.println("Name: " + name);
         System.out.println("CGPA: " + getCGPA());
         System.out.println("Research Topic: " + researchTopic);

        System.out.println();
         System.out.println("************************");
   }
}

public class  UniversityManagementSystem {
   public static void main(String[] args) {
       PostgraduateStudent student = new PostgraduateStudent(101, "Student_01", 4.8, "Cyber Security");
       student.displayDetails();
       student.setCGPA(8.2);
       System.out.println("\nUpdated CGPA: " + student.getCGPA());
   }
}
