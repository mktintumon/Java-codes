import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookstoreGUI extends JFrame {
    private JTextArea bookDisplayArea;
    private JButton addToCartButton;
    private JButton removeFromCartButton;
    private JButton checkoutButton;
    private JTextField bookInputField;
    private JTextArea cartDisplayArea;

    public BookstoreGUI() {
        setTitle("Online Bookstore");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        bookDisplayArea = new JTextArea();
        bookDisplayArea.setEditable(false);
        JScrollPane bookScrollPane = new JScrollPane(bookDisplayArea);
        add(bookScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addToCartButton = new JButton("Add to Cart");
        removeFromCartButton = new JButton("Remove from Cart");
        checkoutButton = new JButton("Checkout");

        buttonPanel.add(addToCartButton);
        buttonPanel.add(removeFromCartButton);
        buttonPanel.add(checkoutButton);
        add(buttonPanel, BorderLayout.SOUTH);

        bookInputField = new JTextField();
        add(bookInputField, BorderLayout.NORTH);

        cartDisplayArea = new JTextArea();
        cartDisplayArea.setEditable(false);
        JScrollPane cartScrollPane = new JScrollPane(cartDisplayArea);
        add(cartScrollPane, BorderLayout.EAST);

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book = bookInputField.getText();
                addToCart(book);
            }
        });

        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book = bookInputField.getText();
                removeFromCart(book);
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });
    }

    private void addToCart(String book) {
        // Add the book to the cart and update the display
        cartDisplayArea.append(book + "\n");
        bookInputField.setText("");
    }

    private void removeFromCart(String book) {
        // Remove the book from the cart and update the display
        String cartContents = cartDisplayArea.getText();
        if (cartContents.contains(book)) {
            cartContents = cartContents.replace(book + "\n", "");
            cartDisplayArea.setText(cartContents);
        }
        bookInputField.setText("");
    }

    private void checkout() {
        // Check if the cart is empty and show an error message if it is
        String cartContents = cartDisplayArea.getText();
        if (cartContents.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty. Add some books before checking out.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Perform the checkout process
            // ...
            // Show a success message or perform further actions
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BookstoreGUI gui = new BookstoreGUI();
                gui.setVisible(true);
            }
        });
    }
}

