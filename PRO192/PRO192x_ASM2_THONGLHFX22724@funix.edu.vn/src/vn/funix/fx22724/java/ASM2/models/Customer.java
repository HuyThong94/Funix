package vn.funix.fx22724.java.ASM2.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremiumCustomer() {
        // Kiểm tra nếu ít nhất một tài khoản của khách hàng là premium
        for (Account account : accounts) {
            if (account.isPremiumAccount()) {
                return true;
            }
        }
        return false;
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
        System.out.println(getCustomerId() + " | " + getName() + " | " + (isPremiumCustomer() ? "Premium":"Normal" ) + " | " + (String.format("%,.0f", getBalance()) + "đ"));
        System.out.println("Danh sách tài khoản:");
        int idx = 1;
        for (Account account : accounts) {
            System.out.printf("%-5s %-5s | %-" + (getName().length() + (isPremiumCustomer() ? 8:7 )) + "s %"+(String.format("%,.0f", getBalance()) + "đ").length()+"s%n", idx, account.getAccountNumber(), "", (String.format("%,.0f", account.getBalance()) + "đ"));
            idx++;
        }
    }
}

