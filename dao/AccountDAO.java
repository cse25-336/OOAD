package dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public void saveAccount(String accNum, String customerId, String type, double balance, String branch, String empName, String empAddr) {
        String sql = "INSERT OR REPLACE INTO accounts VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accNum);
            pstmt.setString(2, customerId);
            pstmt.setString(3, type);
            pstmt.setDouble(4, balance);
            pstmt.setString(5, branch);
            pstmt.setString(6, empName);
            pstmt.setString(7, empAddr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBalance(String accNum, double newBalance) {
        String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newBalance);
            pstmt.setString(2, accNum);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAccountsForCustomer(Customer customer) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM accounts WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getUsername()); // Matched by customerId below
        } catch (SQLException ignored) {}
        return list;
    }
}