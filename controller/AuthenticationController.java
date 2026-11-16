package controller;

import model.Bank;
import model.Customer;

public class AuthenticationController {
    private Bank bank;
    private Customer currentCustomer;

    public AuthenticationController(Bank bank) {
        this.bank = bank;
    }

    public Customer login(String username, String pin) {
        Customer customer = bank.findCustomerByUsername(username);
        if (customer != null && customer.authenticate(pin)) {
            this.currentCustomer = customer;
            return customer;
        }
        return null;
    }

    public void logout() {
        this.currentCustomer = null;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
}
