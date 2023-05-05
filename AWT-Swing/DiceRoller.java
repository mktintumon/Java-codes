/*
 Provide a GUI that enables the user to click a JButton to roll the dice. 
 The application should also display four JLabels and four JTextFields, with one JLabel 
 for each JTextField. The JTextFields should be used to display the values of each die 
 and the sum of the dice after each roll. The point should be displayed in the fourth 
 JTextField when the user does not win or lose on the first roll and should continue to 
 be displayed until the game is lost.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiceRoller extends JFrame implements ActionListener {
    private JTextField die1Field;
    private JTextField die2Field;
    private JTextField sumField;
    private JTextField pointField;
    private JButton rollButton;

    private int point = 0;

    public DiceRoller() {
        super("Dice Roller");

        JPanel inputPanel = new JPanel(new FlowLayout());
        rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(this);
        inputPanel.add(rollButton);

        JPanel outputPanel = new JPanel(new GridLayout(2, 4, 10, 5));
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        outputPanel.add(new JLabel("Die 1:"));
        die1Field = new JTextField(2);
        die1Field.setEditable(false);
        outputPanel.add(die1Field);
        outputPanel.add(new JLabel("Die 2:"));
        die2Field = new JTextField(2);
        die2Field.setEditable(false);
        outputPanel.add(die2Field);
        outputPanel.add(new JLabel("Sum:"));
        sumField = new JTextField(2);
        sumField.setEditable(false);
        outputPanel.add(sumField);
        outputPanel.add(new JLabel("Point:"));
        pointField = new JTextField(2);
        pointField.setEditable(false);
        outputPanel.add(pointField);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(outputPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int sum = die1 + die2;
        die1Field.setText(String.valueOf(die1));
        die2Field.setText(String.valueOf(die2));
        sumField.setText(String.valueOf(sum));
        if (point == 0) {
            if (sum == 7 || sum == 11) {
                JOptionPane.showMessageDialog(this, "You win!");
            } else if (sum == 2 || sum == 3 || sum == 12) {
                JOptionPane.showMessageDialog(this, "You lose!");
            } else {
                point = sum;
                pointField.setText(String.valueOf(point));
            }
        } else {
            if (sum == point) {
                JOptionPane.showMessageDialog(this, "You win!");
                point = 0;
                pointField.setText("");
            } else if (sum == 7) {
                JOptionPane.showMessageDialog(this, "You lose!");
                point = 0;
                pointField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        DiceRoller roller = new DiceRoller();
        roller.setVisible(true);
    }
}

