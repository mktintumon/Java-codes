package Exception_Handling;

class TaxCalculationException extends Exception {
    TaxCalculationException(String msg) {
        //System.out.println(msg);
        super(msg);
    }
}

class Person {
    private String panNumber;
    private double salary;
    private double taxPaid;

    public Person(String panNumber, double salary, double taxPaid) {
        this.panNumber = panNumber;
        this.salary = salary;
        this.taxPaid = taxPaid;
    }

    public void calculateTax() throws TaxCalculationException {
        // tax is 30%
        double tax = salary * 0.3;
        System.out.println("PAN no - " + panNumber);
        if (taxPaid < tax) {
            throw new TaxCalculationException("Tax paid is less than 30% of yearly income");
        }
    }
}

public class TaxException {
    public static void main(String[] args) {
        Person person = new Person("ABC0123YZ", 1000000, 250000);
        
        try {
            person.calculateTax();
            System.out.println("Tax calculation successful");
        } catch (TaxCalculationException e) {
            // e.printStackTrace();
            // e.getMessage() -> derived from super class Exception
            //                -> used super(msg) to call constructor of super class
            System.out.println("Tax calculation failed: " + e.getMessage());
        } finally {
            System.out.println("Taxation completed successfully");
        }
    }
}

