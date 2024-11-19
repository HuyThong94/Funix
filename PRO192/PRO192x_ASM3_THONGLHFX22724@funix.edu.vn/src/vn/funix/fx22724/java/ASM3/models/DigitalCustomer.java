package vn.funix.fx22724.java.ASM3.models;


import vn.funix.fx22724.java.ASM2.models.Account;
import vn.funix.fx22724.java.ASM2.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class DigitalCustomer extends Customer {
    private List<Account> accounts = new ArrayList<>();

    public DigitalCustomer() {}

    public DigitalCustomer(String customerId, String name) {
        super(name, customerId);
    }

    public DigitalCustomer(String customerId, String name, List<Account> accounts) {
        super(name, customerId);
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        if (getAccountByAccountNumber(account.getAccountNumber()) != null) {
            System.out.println("Tài khoản đã tồn tại!");
            return;
        }
        accounts.add(account);
        System.out.println("Thêm tài khoản thành công!");
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account == null) {
            System.out.println("Tài khoản không tồn tại!");
            return;
        }
        if (account.withdraw(amount)) {
            System.out.println("Rút tiền thành công!");
        } else {
            System.out.println("Rút tiền thất bại!");
        }
    }

    public void displayTransactionHistory() {
        for (Account account : accounts) {
//            account.displayTransactionHistory();
        }
    }

    @Override
    public boolean isPremiumCustomer() {
        return super.isPremiumCustomer();
    }

    @Override
    public double getBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-12s | %20s | %7s | %" + (String.format("%,.0f", getBalance()) + "đ").length() + "s%n", getCustomerId(), getName(), (isPremiumCustomer() ? "Premium" : "Normal"), (String.format("%,.0f", getBalance()) + "đ"));
        System.out.println("Danh sách tài khoản:");
        int idx = 1;
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.printf("%-5s %-5s | %12s %7s | %9s %" + (String.format("%,.0f", getBalance()) + "đ").length() + "s%n", idx+".", account.getAccountNumber(), "", account.getTypeAccount(), "", (String.format("%,.0f", account.getBalance()) + "đ"));
                idx++;
            }
        }
    }
}
