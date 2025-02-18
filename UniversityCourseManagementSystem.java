import java.util.*;

abstract class CourseType {
  private String courseName;
  private String instructor;

  public CourseType(String courseName, String instructor) {
    this.courseName = courseName;
    this.instructor = instructor;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getInstructor() {
    return instructor;
  }

  public abstract void displayCourseDetails();
}

class ExamCourse extends CourseType {
  private int totalMarks;

  public ExamCourse(String courseName, String instructor, int totalMarks) {
    super(courseName, instructor);
    this.totalMarks = totalMarks;
  }

  @Override
  public void displayCourseDetails() {
    System.out.println(
        "Exam Course - "
            + getCourseName()
            + " | Instructor: "
            + getInstructor()
            + " | Total Marks: "
            + totalMarks);
  }
}

class AssignmentCourse extends CourseType {
  private int numAssignments;

  public AssignmentCourse(String courseName, String instructor, int numAssignments) {
    super(courseName, instructor);
    this.numAssignments = numAssignments;
  }

  @Override
  public void displayCourseDetails() {
    System.out.println(
        "Assignment Course - "
            + getCourseName()
            + " | Instructor: "
            + getInstructor()
            + " | Assignments: "
            + numAssignments);
  }
}

class ResearchCourse extends CourseType {
  private String researchField;

  public ResearchCourse(String courseName, String instructor, String researchField) {
    super(courseName, instructor);
    this.researchField = researchField;
  }

  @Override
  public void displayCourseDetails() {
    System.out.println(
        "Research Course - "
            + getCourseName()
            + " | Instructor: "
            + getInstructor()
            + " | Research Field: "
            + researchField);
  }
}

class Course<T extends CourseType> {
  private List<T> courses = new ArrayList<>();

  public void addCourse(T course) {
    courses.add(course);
  }

  public List<T> getAllCourses() {
    return courses;
  }
}

class CourseUtils {
  public static void displayCourses(List<? extends CourseType> courses) {
    for (CourseType course : courses) {
      course.displayCourseDetails();
    }
  }
}

public class UniversityCourseManagementSystem {
  public static void main(String[] args) {
    ExamCourse math101 = new ExamCourse("Math 101", "Dr. Smith", 100);
    ExamCourse physics101 = new ExamCourse("Physics 101", "Dr. Brown", 150);

    AssignmentCourse compSci101 = new AssignmentCourse("Computer Science 101", "Dr. Johnson", 5);
    AssignmentCourse econ101 = new AssignmentCourse("Economics 101", "Dr. White", 7);

    ResearchCourse aiResearch =
        new ResearchCourse("AI Research", "Dr. Wilson", "Artificial Intelligence");
    ResearchCourse biotechResearch =
        new ResearchCourse("Biotech Research", "Dr. Green", "Genetics");
    Course<ExamCourse> examCourseCatalog = new Course<>();
    examCourseCatalog.addCourse(math101);
    examCourseCatalog.addCourse(physics101);

    Course<AssignmentCourse> assignmentCourseCatalog = new Course<>();
    assignmentCourseCatalog.addCourse(compSci101);
    assignmentCourseCatalog.addCourse(econ101);

    Course<ResearchCourse> researchCourseCatalog = new Course<>();
    researchCourseCatalog.addCourse(aiResearch);
    researchCourseCatalog.addCourse(biotechResearch);
    System.out.println("\nExam Courses:");
    CourseUtils.displayCourses(examCourseCatalog.getAllCourses());

    System.out.println("\nAssignment Courses:");
    CourseUtils.displayCourses(assignmentCourseCatalog.getAllCourses());

    System.out.println("\nResearch Courses:");
    CourseUtils.displayCourses(researchCourseCatalog.getAllCourses());
  }
}
