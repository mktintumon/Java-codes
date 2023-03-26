import java.util.Scanner;

public class EnglishToLatin {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String sentence, pigLatinSentence;
        boolean keepRunning = true;
        
        while (keepRunning) {
            // Prompt user to enter a sentence
            System.out.print("Enter sentence to convert to Pig Latin (type 'exit' to quit): ");
            sentence = input.nextLine();
            
            // Check if user wants to exit
            if (sentence.equals("exit")) {
                System.out.println("Exiting application...");
                keepRunning = false;
            } else {
                // Convert the sentence to Pig Latin
                pigLatinSentence = convertToPigLatin(sentence);
                
                // Print the Pig Latin sentence
                System.out.println("Pig Latin Sentence: " + pigLatinSentence);
            }
        }
        
        input.close();
    }
    
    
    public static String convertToPigLatin(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        String pigLatinWord, pigLatinSentence = "";
        
        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            String restOfWord = word.substring(1);
            
            pigLatinWord = restOfWord + firstLetter + "ay";
            
            // Add the Pig Latin word to the sentence
            pigLatinSentence += pigLatinWord + " ";
        }
        
        return pigLatinSentence;
    }
}

