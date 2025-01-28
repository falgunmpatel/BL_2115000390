import java.util.Scanner;

class QuadraticSolver {

   public static double[] findRoots(double a, double b, double c) {
      double delta = Math.pow(b, 2) - 4 * a * c;
      if (delta > 0) {
         double root1 = (-b + Math.sqrt(delta)) / (2 * a);
         double root2 = (-b - Math.sqrt(delta)) / (2 * a);
         return new double[] { root1, root2 };
      } else if (delta == 0) {
         double root = -b / (2 * a);
         return new double[] { root };
      } else {
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a: ");
      double a = scanner.nextDouble();
      System.out.print("Enter b: ");
      double b = scanner.nextDouble();
      System.out.print("Enter c: ");
      double c = scanner.nextDouble();

      double[] roots = findRoots(a, b, c);

      if (roots.length == 0) {
         System.out.println("No real roots.");
      } else {
         for (int i = 0; i < roots.length; i++) {
            System.out.println("Root " + (i + 1) + ": " + roots[i]);
         }
      }
   }
}
