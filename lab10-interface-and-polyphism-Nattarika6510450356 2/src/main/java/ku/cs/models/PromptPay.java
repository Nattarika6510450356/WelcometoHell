package ku.cs.models;

public class PromptPay implements Cash{
    private String phoneNumber;
    private BankAccount account;
    public PromptPay(String phoneNumber, BankAccount account){
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BankAccount getAccount() {
        return account;
    }


    @Override
    public boolean getCash(double amount) {
        if (account.withdraw(amount)){
            return true;
        }
        return false;
    }



    @Override
    public String getInfo() {
        return "PromptPay phone number : "+phoneNumber;
    }
    @Override
    public String toString() {
        return "PromptPay{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account +
                '}';
    }

}