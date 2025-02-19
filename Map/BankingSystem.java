import java.util.*;

class WithdrawalRequest {
  String accountNumber;
  double amount;

  public WithdrawalRequest(String accountNumber, double amount) {
    this.accountNumber = accountNumber;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "WithdrawalRequest{"
        + "accountNumber='"
        + accountNumber
        + '\''
        + ", amount="
        + amount
        + '}';
  }
}

public class BankingSystem {
  private Map<String, Double> accounts = new HashMap<>();
  private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
  private Queue<WithdrawalRequest> withdrawalQueue =
      new PriorityQueue<>((a, b) -> Double.compare(a.amount, b.amount));

  public void createAccount(String accountNumber, double initialBalance) {
    accounts.put(accountNumber, initialBalance);
    sortedAccounts.put(initialBalance, accountNumber);
  }

  public void processWithdrawal(String accountNumber, double amount) {
    if (accounts.containsKey(accountNumber)) {
      withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    } else {
      System.out.println("Account not found!");
    }
  }

  public void completeWithdrawals() {
    while (!withdrawalQueue.isEmpty()) {
      WithdrawalRequest request = withdrawalQueue.poll();
      double currentBalance = accounts.get(request.accountNumber);
      if (currentBalance >= request.amount) {
        accounts.put(request.accountNumber, currentBalance - request.amount);
        sortedAccounts.remove(currentBalance);
        sortedAccounts.put(currentBalance - request.amount, request.accountNumber);
        System.out.println("Withdrawal completed: " + request);
      } else {
        System.out.println("Insufficient balance for: " + request);
      }
    }
  }

  public void displayAccounts() {
    System.out.println("Accounts (AccountNumber -> Balance): " + accounts);
  }

  public void displaySortedByBalance() {
    System.out.println("Accounts (Sorted by Balance): " + sortedAccounts);
  }

  public static void main(String[] args) {
    BankingSystem system = new BankingSystem();
    system.createAccount("ACCOUNT1", 2000.0);
    system.createAccount("ACCOUNT2", 5500.0);
    system.createAccount("ACCOUNT3", 1000.0);
    system.displayAccounts();
    system.processWithdrawal("ACCOUNT1", 500.0);
    system.processWithdrawal("ACCOUNT2", 250.0);
    system.processWithdrawal("ACCOUNT3", 500.0);
    system.completeWithdrawals();
    system.displayAccounts();
    system.displaySortedByBalance();
  }
}
