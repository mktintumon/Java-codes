/*
Develop and test a class with TreeSet of objects of type Transaction 
for modeling a transaction involving transfer of money from one account 
number to another. A Transaction object is characterized by its transaction id,
amount in rupees, source account number and destination account number. 
Populate the tree set with three such objects. Show how to iterate through
the elements of the tree set. Display the transaction id with the maximum
transaction amount and display transaction ids with amount less than five 
thousand rupees.
*/


import java.util.TreeSet;

class Transaction implements Comparable<Transaction> {
    private int id;
    private double amount;
    private String srcAccount;
    private String destAccount;

    public Transaction(int id, double amount, String srcAccount, String destAccount) {
        this.id = id;
        this.amount = amount;
        this.srcAccount = srcAccount;
        this.destAccount = destAccount;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getSrcAccount() {
        return srcAccount;
    }

    public String getDestAccount() {
        return destAccount;
    }

    @Override
    public int compareTo(Transaction other) {
        return Double.compare(this.amount, other.amount);
    }
}

public class TransactionManager {
    public static void main(String[] args) {

        // Create and add three Transaction objects to the TreeSet
        Transaction t1 = new Transaction(1, 5000.0, "A123", "B456");
        Transaction t2 = new Transaction(2, 7500.0, "C789", "D012");
        Transaction t3 = new Transaction(3, 3000.0, "E345", "F678");

        TreeSet<Transaction> ts = new TreeSet<>();
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);

        // Iterate through the elements of the TreeSet
        System.out.println("All Transactions:");
        System.out.println("ID's\tAmount\tSrc Account\tDest Account");
        for (Transaction t : ts) {
            System.out.println(t.getId()+"\t"+t.getAmount()+"\t"+t.getSrcAccount()+"\t\t"+t.getDestAccount());
        }


        // Find transaction with maximum amount -> sorted treeset by Amount
        Transaction max = ts.last();
        System.out.println("\nTransaction with Maximum Amount:");
        System.out.println(max.getId()+"\t"+max.getAmount()+"\t"+max.getSrcAccount()+"\t"+max.getDestAccount());


        // Find transactions with amount less than five thousand rupees
        System.out.println("\nTransactions with Amount Less Than Five Thousand Rupees:");
        for (Transaction t : ts) {
            if (t.getAmount() < 5000.0) {
                System.out.println(t.getId()+"\t"+t.getAmount()+"\t"+t.getSrcAccount()+"\t"+t.getDestAccount());
            }
        }
    }
}
