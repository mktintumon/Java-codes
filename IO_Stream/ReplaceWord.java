import java.io.*;

/* 
Write a program that removes all the occurrences of a specified 
string from a text file. For example, invoking java Exercise12_11 John 
filename removes the string John from the specified file. 
Your program should get the arguments from the command line.
*/

public class ReplaceWord {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RepalceWord <string> <filename>");
            System.exit(1);
        }
        
        String targetString = args[0];
        String filename = args[1];
        
        try {
            File inputFile = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(targetString, "");
                stringBuilder.append(line).append("\n");
            }
            
            reader.close();
            
            FileWriter writer = new FileWriter(inputFile);
            writer.write(stringBuilder.toString());
            writer.close();
            
            System.out.println("Removed all occurrences of \"" + targetString + "\" from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
