//import java.util.*;
import java.util.Scanner;

public class LetterOccurances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String input = sc.nextLine();

        int[] letterCounts = new int[26]; 
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            char lc = Character.toLowerCase(ch);
            if (Character.isLetter(lc)) { // Only count letters
                letterCounts[lc - 'a']++;
            }
        }
        System.out.println("Letter\tCount");
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('a' + i);
            if(letterCounts[i] != 0)
                System.out.println(letter + "\t" + letterCounts[i]);
        }
        sc.close();
    }
}
