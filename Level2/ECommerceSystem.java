import java.util.*;

class ECommercePlatform {
    private String platformName;
    private List<Customer> customers;
    private List<Order> orders;

    ECommercePlatform(String platformName) {
        this.platformName = platformName;
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("Cannot add a null customer!");
            return;
        }
        customers.add(customer);
        System.out.printf("Customer \"%s\" added to platform \"%s\".%n", customer.getName(), platformName);
    }

    public void addOrder(Order order) {
        if (order == null) {
            System.out.println("Cannot add a null order!");
            return;
        }
        orders.add(order);
        System.out.printf("Order #%d added to platform \"%s\".%n", order.getOrderId(), platformName);
    }

    public void printPlatformInfo() {
        System.out.println("\n********* E-Commerce Platform Info **********");
        System.out.println("Platform Name: " + this.platformName);
        if (customers.isEmpty()) {
            System.out.println("No customers in the platform.");
        } else {
            System.out.println("Customers:");
            for (Customer customer : customers) {
                System.out.println("- " + customer.getName());
            }
        }
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            System.out.println("Orders:");
            for (Order order : orders) {
                System.out.println("- Order #" + order.getOrderId() + " (Customer: " + order.getCustomerName() + ")");
            }
        }
        System.out.println("*********************************\n");
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void placeOrder(Order order) {
        if (order == null) {
            System.out.println("Cannot place a null order!");
            return;
        }
        orders.add(order);
        System.out.printf("Customer \"%s\" placed order #%d.%n", name, order.getOrderId());
    }

    public void printOrders() {
        System.out.println("\n*** Customer: " + name + " ***");
        if (orders.isEmpty()) {
            System.out.println("No orders placed yet.");
        } else {
            System.out.println("Orders:");
            for (Order order : orders) {
                order.printOrderInfo();
            }
        }
        System.out.println("*********************************\n");
    }
}

class Order {
    private static int orderCounter = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;

    Order(Customer customer) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getCustomerName() {
        return this.customer.getName();
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Cannot add a null product!");
            return;
        }
        products.add(product);
        System.out.printf("Product \"%s\" added to order #%d.%n", product.getName(), orderId);
    }

    public void printOrderInfo() {
        System.out.println("\n--- Order #" + orderId + " ---");
        System.out.println("Customer: " + customer.getName());
        if (products.isEmpty()) {
            System.out.println("No products in this order.");
        } else {
            System.out.println("Products:");
            for (Product product : products) {
                product.printProductInfo();
            }
        }
        System.out.println("*********************************\n");
    }
}

class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void printProductInfo() {
        System.out.println("- " + name + " ($" + price + ")");
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform("ShopNow");

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        platform.addCustomer(customer1);
        platform.addCustomer(customer2);

        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);
        Product product3 = new Product("Headphones", 89.99);

        Order order1 = new Order(customer1);
        Order order2 = new Order(customer2);

        order1.addProduct(product1);
        order1.addProduct(product2);
        order2.addProduct(product3);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        platform.addOrder(order1);
        platform.addOrder(order2);

        platform.printPlatformInfo();
        customer1.printOrders();
        customer2.printOrders();
    }
}

