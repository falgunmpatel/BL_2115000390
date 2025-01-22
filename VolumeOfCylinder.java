import java.util.*;
public class VolumeOfCylinder{  
    public static void main(String args[])  
    {  
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the height and radius of the cylinder: ");
        int height = scanner.nextInt();  
        int radius = scanner.nextInt(); 

        double pie = 3.14285714286;  
        double volume = pie*(radius*radius)*height;  
        System.out.println("Volume of the cylinder="+volume);  
    }  
}  
