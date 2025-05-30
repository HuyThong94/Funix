package vn.funix.fx22724.java.ASM2.models;

public class Account {
    private String accountNumber;
    private double balance;

    public Account() {}

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

    public boolean isAccountPremium() {
        return balance >= 10000000;
    }

    @Override
    public String toString() {
        String balanceFormatted = String.format("%,.0f", getBalance()) + "đ";
        return String.format(" %-5s | %32s %20s%n", getAccountNumber(), "", balanceFormatted);
    }
}

