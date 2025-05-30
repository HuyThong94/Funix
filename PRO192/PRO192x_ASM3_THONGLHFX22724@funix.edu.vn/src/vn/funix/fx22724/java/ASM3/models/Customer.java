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

    public Customer(String name, String customerId, List<Account> accountLst) {
        super(name, customerId);
        accounts = accountLst;
    }

    public void setAccounts(List<Account> accountLst) {
        accounts = accountLst;
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static boolean isCustomerPremium() {
        // Kiểm tra nếu ít nhất một tài khoản của khách hàng là premium
        boolean isAccountPremium = false;
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.isAccountPremium()) {
                    isAccountPremium = true;
                }
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
        System.out.printf("%-12s | %20s | %7s | %20s%n", getCustomerId(), getName(), (isCustomerPremium() ? "Premium" : "Normal"), (String.format("%,.0f", getTotalAccountBalance()) + "đ"));
        System.out.println("Danh sách tài khoản:");
        int idx = 1;
        for (Account account : accounts) {
            System.out.printf("%-5s", idx);
            System.out.printf(account.toString());
            idx++;
        }
    }
}

