package ku.cs.models;

public class Wallet {
    private double balance;

    public Wallet(){
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "balance=" + balance +
                '}';
    }

    public boolean addMoneyToWallet(BankAccount account, double amount){
        if (account.withdraw(amount)){
            balance += amount;
            return true;
        }
        return false;
    }
    public boolean takeMoneyOutOfWallet(double amount){
        if (balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean addMoneyToWallet(Cash cash, double amount) {
        if (cash.getCash(amount)){
            balance += amount;
            return true;
        }
        return false;
    }
}
