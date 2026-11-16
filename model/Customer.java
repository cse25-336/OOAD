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
        super(firstName, surname, address, phone); // Sends details to Person
        this.customerId = customerId;
        this.username = username;
        this.hashedPin = pin; // Keep simple for now; you can hash later
        this.isEmployed = isEmployed;
        this.accounts = new ArrayList<>();
    }

    public boolean authenticate(String enteredPin) {
        return this.hashedPin.equals(enteredPin);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

     public String getUsername() { 
        return username; 
    }

    public List<Transaction> viewTransactionHistory() {
        List<Transaction> allTransactions = new ArrayList<>();
        for (Account acc : accounts) {
            allTransactions.addAll(acc.getTransactions());
        }
        return allTransactions;
    }
    

}
