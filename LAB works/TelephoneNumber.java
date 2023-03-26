
import java.util.Scanner;

public class TelephoneNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a phone number in the form (555) 555-5555: ");
        String phoneNumber = input.nextLine();
        
        // Use String method split to extract area code, first three digits and last four digits
        String[] tokens = phoneNumber.split("[()-]+");
        // 
        String areaCode = tokens[1];
        String firstThreeDigits = tokens[2];
        String lastFourDigits = tokens[3];
        
        // Concatenate the seven digits of the phone number into one string
        String phoneNum = firstThreeDigits + lastFourDigits;
        
        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + phoneNum);
        input.close();
    }
}

