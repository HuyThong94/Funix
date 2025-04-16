package vn.funix.fx22724.java.asm04.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Account> accounts;

    public Customer() {
        super();
        accounts = new ArrayList<>();
    }

    public Customer(String name, String customerId) {
        super(name, customerId);
        accounts = new ArrayList<>();
    }

    public Customer(List<String> values) {
        this(values.get(0), values.get(1));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isCustomerPremium() {
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
        System.out.printf("%-12s | %20s | %7s | %" + (String.format("%,.0f", getTotalAccountBalance()) + "đ").length() + "s%n", getCustomerId(), getName(), (isCustomerPremium() ? "Premium" : "Normal"), (String.format("%,.0f", getTotalAccountBalance()) + "đ"));
        int idx = 1;
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.printf("%-5s %-5s | %12s %7s | %9s %" + (String.format("%,.0f", getTotalAccountBalance()) + "đ").length() + "s%n", idx + ".", account.getAccountNumber(), "", account.getTypeAccount(), "", (String.format("%,.0f", account.getBalance()) + "đ"));
                idx++;
            }
        }
    }

    public void getAccountByAccountNumber(List<Account> accounts, String accountNumber) {}
    public void displayTransactionInformation(){}
    public void withdraw(Scanner sc){}
    public void tranfers(Scanner sc){}

}

