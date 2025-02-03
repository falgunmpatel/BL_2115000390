class Product {
    private static double discount = 0.10;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayProductInfo() {
        System.out.println("*********************");
        System.out.println();

        System.out.println("Product Info: ");
        System.out.println("Name: " + this.productName);
        System.out.println("Price: " + this.price);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Product ID: " + this.productID);
        System.out.println("Discount: " + discount * 100 + "%");

        System.out.println();
        System.out.println("*********************");
    }

    double calculateTotalPrice() {
        return (price * quantity) * (1 - discount);
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000.0, 2, 101);
        Product product2 = new Product("Smartphone", 500.0, 1, 102);

        Product.updateDiscount(0.15);

        if (product1 instanceof Product) {
            product1.displayProductInfo();
            System.out.println("Total Price after discount: " + product1.calculateTotalPrice());
        }

        if (product2 instanceof Product) {
            product2.displayProductInfo();
            System.out.println("Total Price after discount: " + product2.calculateTotalPrice());
        }
    }
}

