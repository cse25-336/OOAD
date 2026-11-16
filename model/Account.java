package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String branch;
    protected Customer owner;
    protected List<Transaction> transactions;

    public Account(String accountNumber, double initialDeposit, String branch, Customer owner) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.branch = branch;
        this.owner = owner;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            recordTransaction(TransactionType.DEPOSIT, amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Helper method to log every transaction cleanly
    protected void recordTransaction(TransactionType type, double amount) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        transactions.add(new Transaction(id, type, amount, balance));
    }

    public abstract double calculateInterest();

    public String getAccountSummary() {
        return "Account: " + accountNumber + " (" + this.getClass().getSimpleName() + ") | Balance: BWP " + balance;
    }
}