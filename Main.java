import model.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Gaborone Bank", "GB001");

        // 1. Register an employed customer
        Customer thabo = bank.registerCustomer("C001", "Thabo", "Molefe", "Plot 123, Gaborone", "71234567", "thabo", "1234", true);

        // 2. Open all 3 account types
        SavingsAccount savings = new SavingsAccount("SAV-101", 1000.00, "Main Mall", thabo);
        InvestmentAccount invest = new InvestmentAccount("INV-102", 600.00, "Main Mall", thabo);
        ChequeAccount cheque = new ChequeAccount("CHQ-103", 0.00, "Main Mall", thabo, "TechCorp", "CBD Gaborone");

        bank.addAccount(savings);
        bank.addAccount(invest);
        bank.addAccount(cheque);

        // 3. Test transactions & monthly interest
        cheque.creditSalary(5000.00, "TechCorp");
        invest.withdraw(100.00);
        bank.payMonthlyInterest();

        // 4. Print summaries
        for (Account acc : thabo.getAccounts()) {
            System.out.println(acc.getAccountSummary());
        }
    }
}