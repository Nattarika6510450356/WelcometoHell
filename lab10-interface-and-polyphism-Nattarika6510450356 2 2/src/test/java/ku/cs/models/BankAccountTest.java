package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    @DisplayName("Deposit 1")
    public void testDeposit() {
        BankAccount B = new BankAccount("1", "Rich",1000.0);
        B.deposit(500.0);
        assertEquals(1500.0,B.getBalance());
    }

    @Test
    @DisplayName("Withdraw 1")
    public void testWithdraw() {
        BankAccount B = new BankAccount("1", "Rich",1000.0);
        B.withdraw(500.0);
        assertEquals(500.0,B.getBalance());
    }
}