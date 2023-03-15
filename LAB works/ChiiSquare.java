import java.security.SecureRandom;

class Rollingdice{
    
    void rolling(){

        SecureRandom rand = new SecureRandom();

        // the sum of the values will vary from 2 to 12, 
        // with 7 being the most frequent sum, 
        // and 2,12 the least frequent
        int[] counts = new int[11]; 
        
        for (int i = 0; i < 1296; i++) { 
            int die1 = rand.nextInt(6) + 1; 
            int die2 = rand.nextInt(6) + 1; 
            int sum = die1 + die2; 

            // incrementing sum each time
            counts[sum - 2]++; 
        }
        
        // printing result obtained
        System.out.println("Sum \tCount");
        for (int i = 0; i < 11; i++) {
            // getting actual sum index by ( i+2 )
            int sum = i + 2; 
            int count = counts[i];
            System.out.println(sum + "\t" + count);
        }
        
        // Expected occurance
        double[] expCounts = new double[11];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int sum = i + j + 2;
                expCounts[sum - 2] += 1.0 / 36;
            }
        }
        
        // Chi-square formula
        double chiSqVal = 0;
        for (int i = 0; i < 11; i++) {
            int observed = counts[i];
            double expected = expCounts[i] * 1296;
            double difference = observed - expected;
            double calculation = (difference * difference) / expected;
            chiSqVal = chiSqVal + calculation;
        }

        System.out.printf("Obtained Chi-square value  : " + "%.3f",chiSqVal);
        System.out.print("\nExpected Chi-square value  : 18.307 ( at LOS -> 5% )");
        
        if (chiSqVal < 18.307) {
            System.out.println("\nConclusion : The dice are UNBIASED.");
        } else {
            System.out.println("\nConclusion : The dice are BIASED.");
        }
    }
}

public class ChiiSquare{
    public static void main(String args[]) {
        // Testing the class
        Rollingdice rd = new Rollingdice();
        rd.rolling();
    }
}
