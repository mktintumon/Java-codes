import java.util.Random;

public class SentenceGenerator {
    public static void main(String[] args) {
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "from", "over", "under", "on"};
        
        Random rand = new Random();
        
        // generate 20 sentences
        for (int i = 1; i <= 5; i++) {
            String word1 = article[rand.nextInt(5)];
            String word2 = verb[rand.nextInt(5)];
            String word3 = preposition[rand.nextInt(5)];
            String word4 = noun[rand.nextInt(5)];
            String sentence =  word1 + " " + word2 + " " + word3 + " " + word4 + ".";
            sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
            System.out.println(sentence);
        }
    }
}

