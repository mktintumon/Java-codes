
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Temperature extends JFrame implements ActionListener {
    private JTextField fahrenheitField;
    private JLabel celsiusLabel;

    public Temperature() {
        super("Fahrenheit to Celsius Converter");

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Fahrenheit:"));
        fahrenheitField = new JTextField(10);
        inputPanel.add(fahrenheitField);

        JPanel outputPanel = new JPanel(new FlowLayout());
        outputPanel.add(new JLabel("Celsius:"));
        celsiusLabel = new JLabel();
        outputPanel.add(celsiusLabel);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(outputPanel, BorderLayout.CENTER);
        mainPanel.add(convertButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText());
            double celsius = (5.0 / 9.0) * (fahrenheit - 32.0);
            celsiusLabel.setText(String.format("%.2f", celsius));
        } catch (NumberFormatException ex) {
            celsiusLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        Temperature converter = new Temperature();
        converter.setVisible(true);
    }
}
