package model;

public class SavingsAccount extends Account implements IInterestBearing {
    private double interestRate = 0.0005; // 0.05%

    public SavingsAccount(String accountNumber, double initialDeposit, String branch, Customer owner) {
        super(accountNumber, initialDeposit, branch, owner);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawals are not allowed from a Savings Account.");
    }
}
