package entities;

public class Account {

    private static final double TAX_ACCOUNT = 5.00;
    private String name;
    private String numberAccount;
    private double balance;

    public Account(String name, String numberAccount, double initialDeposit){
        this.name = name;
        this.numberAccount = numberAccount;
        this.deposit(initialDeposit);
    }

    public Account(String name, String numberAccount){
        this.name = name;
        this.numberAccount = numberAccount;
    }

    public void deposit(double value){
        this.balance += value;
    }

    public void withdraw(double value){
        this.balance -= (value + TAX_ACCOUNT);
    }

    public String toString(){
        return "Account " +
                this.getNumberAccount() +
                ", Holder: " +
                this.getName() +
                ", Balance: $" +
                String.format("%.2f", this.getBalance());
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public double getBalance() {
        return balance;
    }
}
