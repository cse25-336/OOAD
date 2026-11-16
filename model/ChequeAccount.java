package model;

public class ChequeAccount extends Account implements ITransactable {
    private String employerName;
    private String employerAddress;

    public ChequeAccount(String accountNumber, double initialDeposit, String branch, Customer owner, String employerName, String employerAddress) {
        super(accountNumber, initialDeposit, branch, owner);
        if (!owner.isEmployed()) {
            throw new IllegalArgumentException("Customer must be employed to open a Cheque Account.");
        }
        this.employerName = employerName;
        this.employerAddress = employerAddress;
    }

    @Override
    public double calculateInterest() {
        return 0.0; // Cheque accounts do not earn interest
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

    public void creditSalary(double amount, String employer) {
        if (amount > 0) {
            balance += amount;
            recordTransaction(TransactionType.SALARY, amount);
            System.out.println("Salary of BWP " + amount + " credited by " + employer);
        }
    }
}
