package controller;

import model.Bank;

public class InterestController {
    private Bank bank;

    public InterestController(Bank bank) {
        this.bank = bank;
    }

    public void runMonthlyInterest() {
        bank.payMonthlyInterest();
    }
}