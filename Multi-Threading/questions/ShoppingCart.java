import java.util.ArrayList;

public class ShoppingCart {
    private static final int NUM_PRODUCTS = 5;

    public static void main(String[] args) {
        ArrayList<Product> cart = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Iteration " + (i + 1));
            Thread customer = new Thread(() -> {
                for (int j = 0; j < NUM_PRODUCTS; j++) {
                    String productName = "Product " + (j + 1);
                    int quantity = (j + 1) * 2;
                    synchronized (cart) {
                        cart.add(new Product(productName, quantity));
                        cart.notify();
                    }
                }
            });

            Thread display = new Thread(() -> {
                int totalCost = 0;
                synchronized (cart) {
                    while (cart.size() < NUM_PRODUCTS) {
                        try {
                            cart.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Product\t\tQuantity\tPrice\tTotal");
                    for (Product product : cart) {
                        int price = product.getQuantity() * 10;
                        totalCost += price;
                        System.out.printf("%s\t%d\t\t$%d\t$%d\n", product.getName(), product.getQuantity(), price, totalCost);
                    }
                    System.out.println();
                }
            });

            customer.start();
            display.start();
            try {
                customer.join();
                display.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Product {
        private String name;
        private int quantity;

        public Product(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
