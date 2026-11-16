package model;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private LocalDateTime date;
    private TransactionType type;
    private double amount;
    private double balanceAfter;

    public Transaction(String transactionId, TransactionType type, double amount, double balanceAfter) {
        this.transactionId = transactionId;
        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public String getReceipt() {
        return "[" + date + "] " + type + ": BWP " + amount + " | New Balance: BWP " + balanceAfter;
    }

    @Override
    public String toString() {
        return getReceipt();
    }
}
