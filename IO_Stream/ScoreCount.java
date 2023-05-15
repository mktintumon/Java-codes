
import java.io.*;
import java.util.*;

/*
 Suppose that a text file contains an unspecified number of scores 
 separated by blanks. Write a program that prompts the user to enter 
 the file, reads the scores from the file, and displays their total
  and average
 */

public class ScoreCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file containing scores: ");
        String filename = scanner.nextLine();
        
        try {
            File inputFile = new File(filename);
            Scanner fs = new Scanner(inputFile);
            int total = 0;
            int count = 0;
            
            while (fs.hasNextInt()) {
                int score = fs.nextInt();
                total += score;
                count++;
            }
            
            fs.close();
            
            if (count > 0) {
                double average = (double) total / count;
                System.out.println("Total score: " + total);
                System.out.println("Average score: " + average);
            } else {
                System.out.println("No scores found in the file");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        scanner.close();
    }
}

