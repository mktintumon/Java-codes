import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductBillingGUI extends JFrame implements ActionListener {
    private JTextField productNameField, quantityField, priceField, totalBillField;
    private JTextArea productTextArea;
    private JButton addButton, calculateButton;
    private double totalBillAmount;

    public ProductBillingGUI() {
        setTitle("Product Billing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        JLabel productNameLabel = new JLabel("Product Name: ");
        productNameField = new JTextField();
        inputPanel.add(productNameLabel);
        inputPanel.add(productNameField);

        JLabel quantityLabel = new JLabel("Quantity: ");
        quantityField = new JTextField();
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);

        JLabel priceLabel = new JLabel("Price per Unit: ");
        priceField = new JTextField();
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);

        addButton = new JButton("Add Product");
        addButton.addActionListener(this);
        inputPanel.add(addButton);

        calculateButton = new JButton("Calculate Total Bill");
        calculateButton.addActionListener(this);
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        productTextArea = new JTextArea();
        productTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productTextArea);
        add(scrollPane, BorderLayout.CENTER);

        totalBillField = new JTextField();
        totalBillField.setEditable(false);
        add(totalBillField, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String productName = productNameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            double productTotal = quantity * price;
            totalBillAmount += productTotal;

            String productInfo = String.format("%s - Quantity: %d, Price per Unit: %.2f, Total: %.2f\n",
                    productName, quantity, price, productTotal);
            productTextArea.append(productInfo);

            productNameField.setText("");
            quantityField.setText("");
            priceField.setText("");
        } else if (e.getSource() == calculateButton) {
            totalBillField.setText(String.format("Total Bill Amount: %.2f", totalBillAmount));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ProductBillingGUI gui = new ProductBillingGUI();
                gui.setVisible(true);
            }
        });
    }
}
