/*
 Write a program to create a file named Exercise12_15.txt if it does not exist.
  Write 100 integers created randomly into the file using text I/O. 
  Integers are separated by spaces in the file. Read the data back from the
   file and display the data in increasing order.
*/

import java.io.*;
import java.util.*;

public class FileCreate {
    public static void main(String[] args) {
        // Create a File object for the output file
        File outputFile = new File("data.txt");
        
        try {
            // Create a PrintWriter for the output file
            PrintWriter output = new PrintWriter(outputFile);
            
            // Write 100 random integers to the file
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                output.print(rand.nextInt(100) + " ");
            }
            
            // Close the PrintWriter
            output.close();
            
            // Read the data back from the file and display in increasing order
            Scanner input = new Scanner(outputFile);
            int[] data = new int[10];
            int count = 0;
            
            while (input.hasNextInt()) {
                data[count] = input.nextInt();
                count++;
            }
            
            input.close();
            
            Arrays.sort(data);
            
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

