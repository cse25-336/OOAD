package controller;

import model.*;
import java.util.List;

public class TransactionController {
    private Bank bank;

    public TransactionController(Bank bank) {
        this.bank = bank;
    }

    public void deposit(String accountNumber, double amount) {
        Account acc = bank.findAccount(accountNumber);
        if (acc == null) throw new IllegalArgumentException("Account not found.");
        if (amount <= 0) throw new IllegalArgumentException("Amount must be greater than 0.");
        acc.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) {
        Account acc = bank.findAccount(accountNumber);
        if (acc == null) throw new IllegalArgumentException("Account not found.");
        if (acc instanceof ITransactable) {
            ((ITransactable) acc).withdraw(amount);
        } else {
            throw new UnsupportedOperationException("Withdrawals are not allowed on this account.");
        }
    }

    public List<Transaction> viewTransactionHistory(Customer customer) {
        return customer.viewTransactionHistory();
    }
}
