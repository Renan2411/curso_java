package entities;

public class BusinessAccount extends Account {
    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= this.loanLimit) {
            this.balance += amount - 10.0;
        }
    }

    @Override
    public void withdraw(Double amount){
        super.withdraw(amount);
        this.balance -= 2.0;
    }

    public double getLoanLimit() {
        return this.loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }
}
