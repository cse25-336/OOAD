package model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private String customerId;
    private String username;
    private String hashedPin;
    private boolean isEmployed;
    private List<Account> accounts;

    public Customer(String customerId, String firstName, String surname, String address, String phone, String username, String pin, boolean isEmployed) {
        super(firstName, surname, address, phone);
        this.customerId = customerId;
        this.username = username;
        this.hashedPin = pin;
        this.isEmployed = isEmployed;
        this.accounts = new ArrayList<>();
    }

    public boolean authenticate(String pin) {
        return this.hashedPin.equals(pin);
    }

    public void changePin(String oldPin, String newPin) {
        if (authenticate(oldPin)) {
            this.hashedPin = newPin;
        } else {
            throw new IllegalArgumentException("Incorrect current PIN.");
        }
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account openAccount(Account account) {
        this.accounts.add(account);
        return account;
    }

    public void closeAccount(String accountNumber) {
        accounts.removeIf(acc -> acc.getAccountNumber().equals(accountNumber));
    }

    public List<Transaction> viewTransactionHistory() {
        List<Transaction> allTransactions = new ArrayList<>();
        for (Account acc : accounts) {
            allTransactions.addAll(acc.getTransactions());
        }
        return allTransactions;
    }

    public String getCustomerId() { return customerId; }
    public String getUsername() { return username; }
    public boolean isEmployed() { return isEmployed; }
    public List<Account> getAccounts() { return accounts; }

@Override
public String displayContactDetails() {
    return "Customer ID: " + customerId + " | Name: " + getFullName() + " | Phone: " + getPhone() + " | Address: " + getAddress();
}
}