package vn.funix.fx22724.java.ASM2.models;

public class Account {
    private String accountNumber;
    private double balance;

    public Account() {}

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
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
}

