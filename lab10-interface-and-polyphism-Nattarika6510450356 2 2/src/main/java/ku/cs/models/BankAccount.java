package ku.cs.models;

public class BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
    public BankAccount(String accountNumber, String accountName){
        this(accountNumber, accountName, 0);
    }
    public BankAccount(String accountNumber, String accountName, double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    public boolean deposit(double amount){
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        if (amount > 0 && balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
