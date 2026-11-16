package controller;

import model.*;

public class SalaryController {
    private Bank bank;

    public SalaryController(Bank bank) {
        this.bank = bank;
    }

    public void creditSalary(String accountNumber, double amount, String employer) {
        Account acc = bank.findAccount(accountNumber);
        if (acc == null) throw new IllegalArgumentException("Account not found.");
        if (!(acc instanceof ChequeAccount)) {
            throw new IllegalArgumentException("Salaries can only be credited to a Cheque Account.");
        }
        ((ChequeAccount) acc).creditSalary(amount, employer);
    }
}