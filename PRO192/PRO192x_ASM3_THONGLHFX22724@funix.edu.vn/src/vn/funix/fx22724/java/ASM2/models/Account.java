package vn.funix.fx22724.java.ASM2.models;

import vn.funix.fx22724.java.ASM3.models.Transaction;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();
    private String typeAccount;

    public Account() {}

    public Account(String accountNumber, double balance, String typeAccount) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.typeAccount = typeAccount;
    }

    public Account(String accountNumber, double balance, String typeAccount, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.typeAccount = typeAccount;
        this.transactions = transactions;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        // Kiểm tra nếu accountNumber có 6 ký tự số
        if (accountNumber != null && accountNumber.matches("\\d{6}")) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Số tài khoản không hợp lệ! Phải là chuỗi 6 ký tự số.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremiumAccount() {
        return balance >= 10000000;
    }

    @Override
    public String toString() {
        return accountNumber + " | " + String.format("%,.0f", balance) + "đ";
    }

    public boolean withdraw(double amount) {
        if (!isAccepted(amount)) {
            return false;
        }
        setBalance(balance - amount);
        logTransaction(amount, true);
        return true;
    }

    public void logTransaction(double amount, boolean success) {
        Transaction transaction = new Transaction(accountNumber, amount, success);
        transactions.add(transaction);
    }

    public void displayTransactionHistory() {
        System.out.println("Lịch sử giao dịch cho tài khoản " + accountNumber + ":");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public boolean isAccepted(double amount) {
        return false;
    }

    public void displayInformation() {
        System.out.println("Số tài khoản: " + accountNumber + ", Số dư: " + balance);
    }
}

