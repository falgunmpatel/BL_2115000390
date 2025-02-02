class Product {
   private String productName;
   private float price;
   private static int totalProduct = 0;

   Product(String productName, float price){
       this.productName = productName;
       this.price = price;
       totalProduct++;
   }

   void displayProductDetails(){
       System.out.println("*************************");
       System.out.println();

       System.out.println("Product name is: " + productName);
       System.out.println("Price of the product is: " + price);

       System.out.println();
       System.out.println("************************");
   }

   static void displayTotalProduct(){
       System.out.println("\nTotal products are: " + totalProduct);
   }

}

public class ProductInventory {
   public static void main(String[] args){
       Product product1 = new Product("Headphones", 1200);
       Product product2 = new Product("Colgate", 20);

       product1.displayProductDetails();
       product2.displayProductDetails();

       Product.displayTotalProduct();
   }
}

