import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class BankAccount {
  private double balance;

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
    }
  }

  public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
    } else {
      throw new IllegalArgumentException("Insufficient funds or invalid amount");
    }
  }

  public double getBalance() {

    return balance;
  }
}

public class BankAccountTest {
  BankAccount account;

  @BeforeEach
  public void setUp() {
    account = new BankAccount();
  }

  @Test
  public void testDeposit() {
    account.deposit(100.0);
    assertEquals(100.0, account.getBalance());
  }

  @Test
  public void testWithdraw() {
    account.deposit(100.0);
    account.withdraw(50.0);
    assertEquals(50.0, account.getBalance());
  }

  @Test
  public void testWithdrawInsufficientFunds() {
    account.deposit(50.0);
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
  }
}
