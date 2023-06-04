/*
You are tasked with developing and testing a program that takes a file of customer orders
and outputs the total revenue by product. Implement the program that reads the file, creates
a Map<Product, Integer> to store each product's revenue, and updates the revenue as the orders
 are processed. You will also need to implement sorting and output formatting to display the
results in a readable format.
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class CustomerRevenueCalculator {
    public static void main(String[] args) {
        Map<Product, Integer> revenueMap = new HashMap<>();
        List<Order> orderList = new ArrayList<>();

        // Read the file and process orders
        try {
            Scanner sc = new Scanner(new File("Generics\\Scenario-based\\customer_orders.txt"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] orderData = line.split(",");

                String productName = orderData[0].trim();
                double productPrice = Double.parseDouble(orderData[1].trim());
                int quantity = Integer.parseInt(orderData[2].trim());

                Product product = new Product(productName, productPrice);
                Order order = new Order(product, quantity);

                orderList.add(order);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // Calculate revenue by product
        for (Order order : orderList) {
            Product product = order.getProduct();
            int quantity = order.getQuantity();
            double price = product.getPrice();

            int revenue = revenueMap.getOrDefault(product, 0);
            revenue += quantity * price;

            revenueMap.put(product, revenue);
        }

        // Sort products by revenue in descending order
        List<Map.Entry<Product, Integer>> sortedEntries = new ArrayList<>(revenueMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Display revenue by product
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        System.out.println("Revenue by Product:");
        for (Map.Entry<Product, Integer> entry : sortedEntries) {
            Product product = entry.getKey();
            int revenue = entry.getValue();
            String productName = product.getName();
            String formattedRevenue = decimalFormat.format(revenue);

            System.out.println(productName + " ==> Rs: " + formattedRevenue);
        }
    }
}

