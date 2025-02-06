import java.util.*;

class Bank {
    private String bankName;
    private List<Account> accounts;

    Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public String getBankName() {
        return this.bankName;
    }

    public void openAccount(Customer customer, double initialDeposit) {
        if (customer == null) {
            System.out.println("Cannot create an account for a null customer!");
            return;
        }
        Account newAccount = new Account(customer, initialDeposit, this);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        System.out.printf("Account opened for %s in %s with balance: %.2f%n",
                customer.getName(), this.bankName, initialDeposit);
    }

    public void printBankInfo() {
        System.out.println("\n********* Bank Info **********");
        System.out.println("Bank Name: " + this.bankName);
        if (accounts.isEmpty()) {
            System.out.println("No accounts in this bank.");
        } else {
            for (Account acc : accounts) {
                System.out.println(acc);
            }
        }
        System.out.println("*********************************\n");
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("\n********* Account Balance **********");
        System.out.println("Customer: " + this.name);
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account acc : accounts) {
                System.out.printf("Bank: %s | Balance: %.2f%n", acc.getBankName(), acc.getBalance());
            }
        }
        System.out.println("*************************************\n");
    }
}

class Account {
    private Customer customer;
    private double balance;
    private Bank bank;

    public Account(Customer customer, double balance, Bank bank) {
        this.customer = customer;
        this.balance = balance;
        this.bank = bank;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getBankName() {
        return this.bank.getBankName();
    }

    @Override
    public String toString() {
        return String.format("Account Holder: %s | Bank: %s | Balance: %.2f",
                this.customer.getName(), this.bank.getBankName(), this.balance);
    }
}

public class BankAndCustomers {
    public static void main(String[] args) {
        Bank bank1 = new Bank("Bank_01");
        Bank bank2 = new Bank("Bank_02");

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        bank1.openAccount(customer1, 500.00);
        bank1.openAccount(customer2, 1000.00);
        bank2.openAccount(customer1, 2000.00);

        bank1.printBankInfo();
        bank2.printBankInfo();

        customer1.viewBalance();
        customer2.viewBalance();
    }
}

