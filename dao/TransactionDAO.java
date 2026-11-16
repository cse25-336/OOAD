package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    public void saveTransaction(String txId, String accNum, String date, String type, double amount, double balanceAfter) {
        String sql = "INSERT INTO transactions VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, txId);
            pstmt.setString(2, accNum);
            pstmt.setString(3, date);
            pstmt.setString(4, type);
            pstmt.setDouble(5, amount);
            pstmt.setDouble(6, balanceAfter);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTransactionsForAccount(String accNum) {
        List<String> history = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE account_number = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accNum);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                history.add("[" + rs.getString("date") + "] " + rs.getString("type") +
                            ": BWP " + rs.getDouble("amount") + " | Balance: BWP " + rs.getDouble("balance_after"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}