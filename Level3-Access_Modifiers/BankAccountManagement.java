class BankAccount {
   public String accountNumber;
   protected String accountHolder;
   private double balance;

   public BankAccount(String accountNumber, String accountHolder, double balance) {
       this.accountNumber = accountNumber;
       this.accountHolder = accountHolder;
       this.balance = balance;
   }

   public void deposit(double amount) {
       balance += amount;
   }

   public void withdraw(double amount) {
       if (balance >= amount) {
           balance -= amount;
       }
   }

   public double getBalance() {
       return balance;
   }

   public void setBalance(double balance) {
       this.balance = balance;
   }
}

class SavingsAccount extends BankAccount {

   public SavingsAccount(String accountNumber, String accountHolder, double balance) {
       super(accountNumber, accountHolder, balance);
   }

   public void displayInfo() {
        System.out.println("*************************");
        System.out.println();

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);

        System.out.println();
        System.out.println("*************************");
   }
}

public class BankAccountManagement {
   public static void main(String[] args) {
       SavingsAccount myAccount = new SavingsAccount("123456789", "Alice", 5000.0);
       myAccount.displayInfo();
       myAccount.deposit(1000);
       myAccount.withdraw(500);
       System.out.println("\nBalance: " + myAccount.getBalance());
       myAccount.setBalance(7000.0);
       System.out.println("\nUpdated Balance: " + myAccount.getBalance());
   }
}
