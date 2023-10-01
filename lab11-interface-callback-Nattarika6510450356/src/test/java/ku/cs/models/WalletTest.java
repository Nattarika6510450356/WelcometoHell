package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    @Test
    @DisplayName("Add Money To Wallet")
    public void testAddMoneyToWallet() {
        Wallet W = new Wallet();
        BankAccount B = new BankAccount("1","Rich",1000.0);
        W.addMoneyToWallet(B,500.0);
        assertEquals(500.0,W.getBalance());
    }

    @Test
    @DisplayName("Take Money Out Of Wallet")
    public void testTakeMoneyOutOfWallet() {
        Wallet W = new Wallet();
        BankAccount B = new BankAccount("1","Rich",1000.0);
        W.addMoneyToWallet(B,500.0);
        W.takeMoneyOutOfWallet(200.0);
        assertEquals(300.0,W.getBalance());

    }

    @Test
    @DisplayName("Add Money To Wallet Cash")
    void testAddMoneyToWalletCash() {
        Wallet W = new Wallet();
        Cash c = new BankAccount("1", "Rich", 1000.0);
        W.addMoneyToWallet(c, 300.0);
        assertEquals(700.0, ((BankAccount) c).getBalance());
    }

}