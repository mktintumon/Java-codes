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

    @Override
    public String toString() {
        return name + " (Rs : " + price + ")";
    }
}

class Website {
    List<Product> products;
    LinkedList<Product> cart;

    public Website() {
        products = new ArrayList<>();
        cart = new LinkedList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Product added: " + p);
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void addToCart(int pIdx) {
        if (pIdx >= 0 && pIdx < products.size()) {
            Product p = products.get(pIdx);
            cart.add(p);
            System.out.println("Added to cart: " + p);
        } else {
            System.out.println("Invalid product index.");
        }
    }

    public void displayCart() {
        System.out.println("User Cart:");
        for (Product p : cart) {
            System.out.println(p);
        }
    }
}

public class ECommerceWebsite {
    public static void main(String[] args) {
        Website web = new Website();

        Product product1 = new Product("Product 1", 1099);
        Product product2 = new Product("Product 2", 3000);
        Product product3 = new Product("Product 3", 1445);

        web.addProduct(product1);
        web.addProduct(product2);
        web.addProduct(product3);

        web.displayProducts();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the product index to add to cart (0-" + (web.products.size() - 1) + "): ");
        int idx = sc.nextInt();
        web.addToCart(idx);

        System.out.print("Enter the product index to add to cart (0-" + (web.products.size() - 1) + "): ");
        idx = sc.nextInt();
        web.addToCart(idx);

        web.displayCart();
        sc.close();
    }
}
