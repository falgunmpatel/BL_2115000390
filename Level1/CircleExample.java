import java.util.*;

class Circle {
    int radius;

    Circle() {
	this(5);
	System.out.println("Default Constructor! Radius: " + this.radius);
    }

    Circle(int radius){
	this.radius = radius;
	System.out.println("Parameterized Constructor! Radius: " + this.radius);
    }
}

public class CircleExample {
    public static void main(String []args) {
	Circle circle = new Circle();
    }
}
