//package LAB works;
import java.util.*;

public class Account {
    
    private String accNo;
    private double balance;
    private String name;

    public Account(String accNo, double balance, String name) {
        this.accNo = accNo;
        this.balance = balance;
        this.name = name;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void withdrawal(double amount){
        if(amount > 20000) return;
        balance -= amount;
    }
    
    public void deposit(double amount){
        balance += amount;
    }
    
    public double computeInterest(double rate){
       return balance*rate / 100;
    }
    
    @Override
    public String toString() {
        return "Account{" + "accNo= " + accNo + ", balance= " + balance + ", name= " + name + '}';
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account no ");
        String accNo = sc.nextLine();
        System.out.println("Enter name ");
        String accName = sc.nextLine();
        System.out.println("Enter balance ");
        double accbal = sc.nextDouble();
        
        Account acc = new Account(accNo , accbal ,accName);
        System.out.println(acc.toString());
        acc.deposit(1000);
        System.out.println("The current balance is : " + acc.getBalance());
        acc.withdrawal(3000);
        System.out.println("The current balance is : " + acc.getBalance());
        System.out.println(acc.computeInterest(0.6)); 
        
        Account acc2 = new Account("45678" , 20000 ,"avrodip");
        System.out.println(acc2.toString());
        acc2.deposit(10000);
        System.out.println("The current balance is : " + acc2.getBalance());
        System.out.println(acc2.toString());
        sc.close();
    }
}



