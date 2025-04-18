package vn.funix.fx22724.java.ASM3.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private static List<Account> accounts;

    public Customer() {
        super();
        accounts = new ArrayList<>();
    }

    public Customer(String name, String customerId) {
        super(name, customerId);
        accounts = new ArrayList<>();
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public static List<Account> getAccounts() {
        return accounts;
    }

    public static boolean isCustomerPremium() {
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

    public double getTotalAccountBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void displayInformation() {
        System.out.printf("%-12s | %20s | %7s | %"+(String.format("%,.0f", getTotalAccountBalance()) + "đ").length()+"s%n", getCustomerId(), getName(), (isCustomerPremium() ? "Premium":"Normal" ), (String.format("%,.0f", getTotalAccountBalance()) + "đ"));
        System.out.println("Danh sách tài khoản:");
        int idx = 1;
        for (Account account : accounts) {
            System.out.printf("%-5s %-5s | %20s %7s %"+(String.format("%,.0f", getTotalAccountBalance()) + "đ").length()+"s%n", idx, account.getAccountNumber(), "", "", (String.format("%,.0f", account.getBalance()) + "đ"));
            idx++;
        }
    }
}

