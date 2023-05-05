/*
Write an application that plays “guess the number” as follows:
Your application chooses the number to be guessed by selecting an integer at random in the range 1–1000.
The application then displays the following in a label:
I have a number between 1 and 1000. Can you guess my number?
Please enter your first guess.
A JTextField should be used to input the guess. As each guess is input, the background color should 
change to either red or blue. Red indicates that the user is getting “warmer,” and blue, “colder.” 
A JLabel should display either "Too High" or "Too Low" to help the user zero in. 
When the user gets the correct answer, "Correct!" should be displayed, and the JTextField used for 
input should be changed to be uneditable. A JButton should be provided to allow the user to play the 
game again. When the JButton is clicked, a new random number should be generated and the input 
JTextField changed to be editable.

 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class GuessTheNumber extends JFrame {

    private int NUMBER_TO_GUESS;
    private final Random random;
    private final JTextField inputField;
    private final JLabel resultLabel;
    private final JButton playAgainButton;
    private int previousGuess;
    private int attempts;

    public GuessTheNumber() {
        super("Guess the Number");

        random = new Random();
        NUMBER_TO_GUESS = random.nextInt(10) + 1;

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());

        JLabel prompt = new JLabel("I have a number between 1 and 10. Can you guess my number?");
        content.add(prompt);

        inputField = new JTextField(5);
        inputField.addActionListener(new GuessHandler());
        content.add(inputField);

        resultLabel = new JLabel("Please enter your first guess.");
        content.add(resultLabel);

        playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new PlayAgainHandler());
        playAgainButton.setVisible(false);
        content.add(playAgainButton);

        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setVisible(true);
    }

    private void handleGuess(int guess) {
        if (guess == NUMBER_TO_GUESS) {
            resultLabel.setText("Correct!");
            inputField.setEditable(false);
            playAgainButton.setVisible(true);
        } else {
            if (attempts == 0) {
                resultLabel.setText("Too " + (guess > NUMBER_TO_GUESS ? "High" : "Low"));
            } else {
                int previousDistance = Math.abs(previousGuess - NUMBER_TO_GUESS);
                int currentDistance = Math.abs(guess - NUMBER_TO_GUESS);
                if (currentDistance < previousDistance) {
                    resultLabel.setForeground(Color.RED);
                    resultLabel.setText("Warmer. Too " + (guess > NUMBER_TO_GUESS ? "High" : "Low"));
                } else {
                    resultLabel.setForeground(Color.BLUE);
                    resultLabel.setText("Colder. Too " + (guess > NUMBER_TO_GUESS ? "High" : "Low"));
                }
            }
            previousGuess = guess;
            attempts++;
        }
        inputField.setText("");
    }

    private class GuessHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int guess = Integer.parseInt(inputField.getText());
            handleGuess(guess);
        }
    }

    private class PlayAgainHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            NUMBER_TO_GUESS = random.nextInt(1000) + 1;
            inputField.setEditable(true);
            resultLabel.setForeground(Color.BLACK);
            resultLabel.setText("Please enter your first guess.");
            playAgainButton.setVisible(false);
            previousGuess = 0;
            attempts = 0;
        }
    }

    public static void main(String[] args) {
        new GuessTheNumber();
    }

}
