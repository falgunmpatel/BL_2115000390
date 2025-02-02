class Course{
   private String courseName;
   private int duration;
   private float fee;

   private static String instituteName = "University_01";

   Course(String courseName, int duration, int fee){
       this.courseName = courseName;
       this.duration = duration;
       this.fee = fee;
   }

   void displayCourseDetails(){
        System.out.println("*************************");
        System.out.println();

        System.out.println("Course name is: " + courseName);
        System.out.println("Duration is: " + duration);
        System.out.println("Fee is: " + fee);

        System.out.println();
        System.out.println("*************************");
   }

   static void updateInstituteName(String name){
       instituteName = name;
       System.out.println("\nInstitute name is updated to: " + instituteName);
   }
}

public class OnlineCourseManagement {
   public static void main(String[] args){
       Course person1 = new Course("B.Sc", 3, 600000);
       Course person2 = new Course("B.Tech", 4, 1500000);
       person1.displayCourseDetails();
       person2.displayCourseDetails();

       Course.updateInstituteName("University_02");
   }

}
