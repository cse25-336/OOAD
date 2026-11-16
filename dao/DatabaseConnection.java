package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:bank.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        String createCustomers = "CREATE TABLE IF NOT EXISTS customers (" +
                "customer_id TEXT PRIMARY KEY, " +
                "first_name TEXT, surname TEXT, address TEXT, phone TEXT, " +
                "username TEXT UNIQUE, pin TEXT, is_employed INTEGER)";

        String createAccounts = "CREATE TABLE IF NOT EXISTS accounts (" +
                "account_number TEXT PRIMARY KEY, " +
                "customer_id TEXT, account_type TEXT, balance REAL, " +
                "branch TEXT, employer_name TEXT, employer_address TEXT)";

        String createTransactions = "CREATE TABLE IF NOT EXISTS transactions (" +
                "transaction_id TEXT PRIMARY KEY, " +
                "account_number TEXT, date TEXT, type TEXT, " +
                "amount REAL, balance_after REAL)";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(createCustomers);
            stmt.execute(createAccounts);
            stmt.execute(createTransactions);
            System.out.println("Database tables ready.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}