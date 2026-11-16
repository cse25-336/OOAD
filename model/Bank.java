package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private String branchCode;
    private List<Customer> customers;
    private List<Account> accounts;

    public Bank(String name, String branchCode) {
        this.name = name;
        this.branchCode = branchCode;
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public Customer registerCustomer(String id, String firstName, String surname, String address, String phone, String username, String pin, boolean isEmployed) {
        Customer customer = new Customer(id, firstName, surname, address, phone, username, pin, isEmployed);
        customers.add(customer);
        return customer;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.owner.addAccount(account);
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public Customer findCustomerByUsername(String username) {
    for (Customer c : customers) {
        if (c.getUsername().equalsIgnoreCase(username)) {
            return c;
        }
    }
    return null;
     }

    public void payMonthlyInterest() {
        for (Account acc : accounts) {
            if (acc instanceof IInterestBearing) {
                double interest = acc.calculateInterest();
                if (interest > 0) {
                    acc.balance += interest;
                    acc.recordTransaction(TransactionType.INTEREST, interest);
                }
            }
        }
    }
}
