package controller;

import model.Bank;
import model.Customer;
import java.util.UUID;

public class RegistrationController {
    private Bank bank;

    public RegistrationController(Bank bank) {
        this.bank = bank;
    }

    public Customer registerCustomer(String firstName, String surname, String address, String phone, String username, String pin, boolean isEmployed) {
        if (firstName.isEmpty() || surname.isEmpty() || username.isEmpty() || pin.isEmpty()) {
            throw new IllegalArgumentException("All required fields must be filled.");
        }
        if (bank.findCustomerByUsername(username) != null) {
            throw new IllegalArgumentException("Username already taken.");
        }
        String customerId = "CUST-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        return bank.registerCustomer(customerId, firstName, surname, address, phone, username, pin, isEmployed);
    }
}
