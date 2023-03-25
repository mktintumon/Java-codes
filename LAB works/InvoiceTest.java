
class Invoice {
    String partNo;
    String description;
    int quantity;
    double price;

    public Invoice(String partNo, String description, int quantity, double price) {
        this.partNo = partNo;
        this.description = description;
        this.quantity = quantity > 0 ? quantity : 0;
        this.price = price > 0.0 ? price : 0.0;
    }

    public double getInvoiceAmount() {
        return quantity * price;
    }
}

public class InvoiceTest {
    public static void main(String[] args) {
        // Create a 2D array of Invoice objects
        Invoice[][] inv = new Invoice[2][2];

        // Initialize the Invoice objects
        inv[0][0] = new Invoice("P001", "Hammer", 2, 12.99);
        inv[0][1] = new Invoice("P002", "Screws", 1, 6.99);
        inv[1][0] = new Invoice("P003", "Wrench", -2, -8.99);
        inv[1][1] = new Invoice("P004", "Pliers", 3, 5.99);

        // Print the invoice amount for each object
        System.out.println("Part\tDescroiption\tQty\tprice");
        for (Invoice[] row : inv) {
            for (Invoice x : row) {
                double amount = x.getInvoiceAmount();
                System.out.println(x.partNo + "\t" + x.description + "\t\t" + x.quantity+"\t" + amount);
            }
        }
    }
}

