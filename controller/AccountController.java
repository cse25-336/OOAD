package controller;

import model.*;
import java.util.UUID;

public class AccountController {
    private Bank bank;

    public AccountController(Bank bank) {
        this.bank = bank;
    }

    public Account openAccount(Customer customer, String type, double initialDeposit, String employerName, String employerAddress) {
        if (type == null) {
            throw new IllegalArgumentException("Please select an account type.");
        }
        String accNum = type.substring(0, 3).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        Account account;

        switch (type) {
            case "Savings":
                account = new SavingsAccount(accNum, initialDeposit, "Gaborone Main", customer);
                break;
            case "Investment":
                account = new InvestmentAccount(accNum, initialDeposit, "Gaborone Main", customer);
                break;
            case "Cheque":
                account = new ChequeAccount(accNum, initialDeposit, "Gaborone Main", customer, employerName, employerAddress);
                break;
            default:
                throw new IllegalArgumentException("Invalid account type.");
        }

        bank.addAccount(account);
        return account;
    }

    public Account findAccount(String accountNumber) {
        return bank.findAccount(accountNumber);
    }
}