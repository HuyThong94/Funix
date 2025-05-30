package vn.funix.fx22724.java.ASM2.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremiumCustomer() {
        // Kiểm tra nếu ít nhất một tài khoản của khách hàng là premium
        boolean isAccountPremium = false;
        for (Account account : getAccounts()) {
            if (account.isAccountPremium()) {
                isAccountPremium = true;
            }
        }
        return isAccountPremium;
    }

    public void addAccount(Account newAccount) {
        // Kiểm tra nếu tài khoản chưa tồn tại
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(newAccount.getAccountNumber())) {
                System.out.println("Tài khoản đã tồn tại!");
                return;
            }
        }
        accounts.add(newAccount);
    }

    public double getBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void displayInformation() {
        System.out.printf("%-12s | %20s | %7s | %20s%n", getCustomerId(), getName(), (isPremiumCustomer() ? "Premium":"Normal" ), (String.format("%,.0f", getBalance()) + "đ"));
        System.out.println("Danh sách tài khoản:");
        int idx = 1;
        for (Account account : accounts) {
            System.out.printf("%-5s", idx);
            System.out.printf(account.toString());
            idx++;
        }
    }
}

