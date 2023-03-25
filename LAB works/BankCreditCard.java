interface transaction {
    void withdraw(double amount);
    void deposit(double amount);
}
  
class BankAccount implements transaction {
    private double balance;
    private int accNumber;
  
    BankAccount(double balance, int accNumber) {
      this.balance = balance;
      this.accNumber = accNumber;
    }

    public void setBalance(double balance) {
       balance = this.balance;
    }

    public double getBalance() {
        return balance;
    }
  
    public void withdraw(double amount) {
      if (amount > balance) {
        System.out.println("Withdrawal amount exceeds account balance!");
        return;
      }
  
      balance -= amount;
      System.out.println("$" + amount + " has been withdrawn from account " + accNumber);
    }
  
    public void deposit(double amount) {
      balance += amount;
      System.out.println("$" + amount + " has been deposited into account " + accNumber);
    }
}
  

class CreditCardAccount implements transaction {
    private double creditLimit;
    private int creditCardNo;
  
    CreditCardAccount(double creditLimit, int creditCardNo) {
      this.creditLimit = creditLimit;
      this.creditCardNo = creditCardNo;
    }

    public void setCreditLimit(double creditLimit) {
      this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
  
    public void withdraw(double amount) {
      if (amount > creditLimit) {
        System.out.println("Withdrawal amount exceeds credit limit!");
        return;
      }
  
      // 5% transaction fee
      double fee = amount * 0.005;
      creditLimit -= (amount + fee);
      System.out.println("$" + amount + " has been withdrawn from credit card " + creditCardNo);
    }
  
    public void deposit(double amount) {
      creditLimit += amount;
      System.out.println("$" + amount + " has been deposited into credit card " + creditCardNo);
    }
}
  
public class BankCreditCard {
    public static void main(String[] args) {
      BankAccount acc = new BankAccount(1000,1234);
      CreditCardAccount ccAcc = new CreditCardAccount(2000 , 5678);
      acc.withdraw(500);
      acc.deposit(200);
      ccAcc.withdraw(1000);
      ccAcc.deposit(500);
  
    
      System.out.println("Account balance: $" + acc.getBalance());
      System.out.println("Credit limit: $" + ccAcc.getCreditLimit());
    }
}
  

