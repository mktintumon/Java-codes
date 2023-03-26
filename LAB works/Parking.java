import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalCharges = 0.0;

        System.out.print("Enter the number of customers: ");
        int numCustomers = input.nextInt();

        for (int i = 1; i <= numCustomers; i++) {
            System.out.print("Enter the hours parked for customer " + i + ": ");
            int hoursParked = input.nextInt();
            double charges = calculateCharges(hoursParked);
            totalCharges += charges;
            System.out.printf("Customer %d: $%.2f\n", i, charges);
        }

        System.out.printf("Total charges for yesterday: $%.2f\n", totalCharges);
        input.close();
    }

    public static double calculateCharges(int hoursParked) {
        double minimumFee = 2.00;
        double hourlyRate = 0.50;
        double maximumFee = 10.00;

        if (hoursParked <= 3) {
            return minimumFee;
        } else if (hoursParked <= 24) {
            double additionalHours = hoursParked - 3;
            double additionalFee = Math.ceil(additionalHours) * hourlyRate;
            double totalFee = minimumFee + additionalFee;
            return Math.min(totalFee, maximumFee);
        } else {
            return maximumFee;
        }
    }
}

