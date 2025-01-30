// Circle class definition
public class Circle {
    // Private field
    private double radius;

    // Constructor to initialize the radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display area and circumference
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }

    // Main method to test Circle class
    public static void main(String[] args) {
        // Creating a Circle object
        Circle circle1 = new Circle(7.0);

        // Displaying Circle details
        System.out.println("=== Circle Details ===");
        circle1.displayDetails();
    }
}
