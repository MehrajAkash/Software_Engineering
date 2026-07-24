
package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClass {

    private BankAccount account;

    // Runs before every test case
    @BeforeEach
    void setUp() {
        account = new BankAccount(1001);
    }

    // Test creating account with valid account number
    @Test
    void testCreateAccountWithValidNumber() {
        assertEquals(1001, account.getAccount());
    }

    // Test creating account with invalid account number
    @Test
    void testCreateAccountWithInvalidNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(0));

        assertEquals("Account Number must be positive", exception.getMessage());
    }

    // Test getAccount()
    @Test
    void testGetAccount() {
        assertEquals(1001, account.getAccount());
    }

    // Test setAccount() with valid account number
    @Test
    void testSetAccountValid() {
        account.setAccount(2002);
        assertEquals(2002, account.getAccount());
    }

    // Test setAccount() with invalid account number
    @Test
    void testSetAccountInvalid() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.setAccount(-10));

        assertEquals("Account Number must be positive", exception.getMessage());
    }

    // Test initial balance
    @Test
    void testInitialBalance() {
        assertEquals(0, account.getBalance());
    }

    // Test deposit valid amount
    @Test
    void testDepositValidAmount() {
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }

    // Test deposit invalid amount
    @Test
    void testDepositInvalidAmount() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0));

        assertEquals("Deposit amount must be greater than 0", exception.getMessage());
    }

    // Test withdraw valid amount
    @Test
    void testWithdrawValidAmount() {
        account.deposit(1000);
        account.withdraw(400);

        assertEquals(600, account.getBalance());
    }

    // Test withdraw more than balance
    @Test
    void testWithdrawInsufficientBalance() {
        account.deposit(500);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> account.withdraw(600));

        assertEquals("Insufficient Balance", exception.getMessage());
    }

    // Test withdraw invalid amount
    @Test
    void testWithdrawInvalidAmount() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0));

        assertEquals("Withdraw amount must be greater than 0", exception.getMessage());
    }

    // Test multiple deposits
    @Test
    void testMultipleDeposits() {
        account.deposit(100);
        account.deposit(200);
        account.deposit(300);

        assertEquals(600, account.getBalance());
    }

    // Test multiple transactions
    @Test
    void testMultipleTransactions() {
        account.deposit(1000);
        account.withdraw(300);
        account.deposit(200);
        account.withdraw(100);

        assertEquals(800, account.getBalance());
    }
}

