package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {

    @Test
    @DisplayName("Deposit 2")
    public void testDeposit() {
        CreditAccount C = new CreditAccount("1","Rich",1000.0);
        C.deposit(300.0);
        assertEquals(1300.0,C.getBalance());
    }

    @Test
    @DisplayName("Withdraw 2")
    public void testWithdraw() {
        CreditAccount C = new CreditAccount("1","Rich",1000.0);
        C.withdraw(200.0);
        assertEquals(800.0,C.getBalance());
    }

    @Test
    @DisplayName("Transfer Cashback")
    public void testTransferCashback() {
        CreditAccount C = new CreditAccount("1","Rich",1000.0);
        assertFalse(C.transferCashback(2500.0));
        assertEquals(1000.0, C.getBalance());
    }

}