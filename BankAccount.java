package in.sp.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankOperations {
    private static final String url = "jdbc:mysql://localhost:3306/BankDB";
    private static final String un = "root";
    private static final String pw = "Happy3*3";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, un, pw);
    }

    public static void openAccount(BankAccount account) {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO Accounts (accountHolderName, balance) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getAccountHolderName());
            pstmt.setDouble(2, account.getBalance());
            pstmt.executeUpdate();
            System.out.println("Account opened for " + account.getAccountHolderName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void depositMoney(int accountNumber, double amount) {
        try (Connection conn = getConnection()) {
            String sql = "UPDATE Accounts SET balance = balance + ? WHERE accountNumber = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountNumber);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Deposited " + amount + " into account " + accountNumber);
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void withdrawMoney(int accountNumber, double amount) {
        try (Connection conn = getConnection()) {
            // Check current balance
            String checkBalanceSql = "SELECT balance FROM Accounts WHERE accountNumber = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkBalanceSql);
            checkStmt.setInt(1, accountNumber);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                if (amount > 0 && amount <= currentBalance) {
                    String sql = "UPDATE Accounts SET balance = balance - ? WHERE accountNumber = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setDouble(1, amount);
                    pstmt.setInt(2, accountNumber);
                    pstmt.executeUpdate();
                    System.out.println("Withdrew " + amount + " from account " + accountNumber);
                } else {
                    System.out.println("Insufficient balance or invalid amount.");
                }
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayAccountDetails(int accountNumber) {
        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM Accounts WHERE accountNumber = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Account Number: " + rs.getInt("accountNumber"));
                System.out.println("Account Holder: " + rs.getString("accountHolderName"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteAccount(int accountNumber) {
        try (Connection conn = getConnection()) {
            String sql = "DELETE FROM Accounts WHERE accountNumber = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Account number " + accountNumber + " deleted successfully.");
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
