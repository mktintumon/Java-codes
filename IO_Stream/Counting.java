import java.io.*;
/*
Write a program that will count the number of characters, words, 
and lines in a file. Words are separated by whitespace characters. 
The file name should be passed as a command-line argument 
*/

public class Counting {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Counting <filename>");
            System.exit(1);
        }
        
        String filename = args[0];
        
        try {
            File inputFile = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;
            String line;
            
            while ((line = reader.readLine()) != null) {
                charCount += line.length();
                wordCount += line.split("\\s+").length;
                lineCount++;
            }
            
            reader.close();
            
            System.out.println("File statistics for " + filename + ":");
            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

