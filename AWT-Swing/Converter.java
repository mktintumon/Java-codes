import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Converter extends JFrame {
    private JLabel decimalLabel, hexLabel, binaryLabel;
    private JTextField decimalField, hexField, binaryField;

    public Converter() {
        super("Number Converter");

        // Create components
        decimalLabel = new JLabel("Enter Decimal value:");
        hexLabel = new JLabel("Enter Hex value:");
        binaryLabel = new JLabel("Enter Binary value:");
        decimalField = new JTextField(15);
        hexField = new JTextField(15);
        binaryField = new JTextField(15);

        // Add components to content pane
        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 2));
        c.add(decimalLabel);
        c.add(decimalField);
        c.add(hexLabel);
        c.add(hexField);
        c.add(binaryLabel);
        c.add(binaryField);

        // Add action listener to decimal field
        decimalField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String decimalStr = decimalField.getText();
                int decimal = Integer.parseInt(decimalStr);
                String hex = Integer.toHexString(decimal);
                String binary = Integer.toBinaryString(decimal);
                hexField.setText(hex);
                binaryField.setText(binary);
            }
        });

        // Add action listener to hex field
        hexField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hex = hexField.getText();
                int decimal = Integer.parseInt(hex, 16);
                String binary = Integer.toBinaryString(decimal);
                decimalField.setText(Integer.toString(decimal));
                binaryField.setText(binary);
            }
        });

        // Add action listener to binary field
        binaryField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String binary = binaryField.getText();
                int decimal = Integer.parseInt(binary, 2);
                String hex = Integer.toHexString(decimal);
                decimalField.setText(Integer.toString(decimal));
                hexField.setText(hex);
            }
        });

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        Converter c = new Converter();
    }
}
