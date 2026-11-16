package model;

public class InvestmentAccount extends Account implements IInterestBearing, ITransactable {
    private double interestRate = 0.05; // 5%
    private static final double MIN_OPENING_BALANCE = 500.00;

    public InvestmentAccount(String accountNumber, double initialDeposit, String branch, Customer owner) {
        super(accountNumber, initialDeposit, branch, owner);
        if (initialDeposit < MIN_OPENING_BALANCE) {
            throw new IllegalArgumentException("Investment account requires at least BWP 500.00 to open.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recordTransaction(TransactionType.WITHDRAWAL, amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}
