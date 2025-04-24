package vn.funix.fx22724.java.ASM3.models;


import vn.funix.fx22724.java.ASM3.models.Account;
import vn.funix.fx22724.java.ASM3.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class DigitalCustomer extends Customer {

    public DigitalCustomer() {
        super();
    }

    public DigitalCustomer(String customerId, String name, List<Account> accounts) {
        super(name, customerId, accounts);
    }

    public void addAccount(Account account) {
        if (getAccountByAccountNumber(account.getAccountNumber()) != null) {
            System.out.println("Tài khoản đã tồn tại!");
            return;
        }
        List<Account> accountList = getAccounts();
        accountList.add(account);
        setAccounts(accountList);
        System.out.println("Thêm tài khoản thành công!");
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        for (Account account : getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account == null) {
            System.out.println("Tài khoản không tồn tại!");
            return false;
        }
        if (account.getTypeAccount().equals("SAVINGS")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            return savingsAccount.withdraw(amount);

        } else {
            LoanAccount loanAccount = (LoanAccount) account;
            return loanAccount.withdraw(amount);
        }

    }

    @Override
    public double getTotalAccountBalance() {
        double totalBalance = 0;
        for (Account account : getAccounts()) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    @Override
    public void displayInformation() {
        System.out.printf("%-12s | %20s | %7s | %" + (String.format("%,.0f", getTotalAccountBalance()) + "đ").length() + "s%n", getCustomerId(), getName(), (isCustomerPremium() ? "Premium" : "Normal"), (String.format("%,.0f", getTotalAccountBalance()) + "đ"));
        System.out.println("Danh sách tài khoản:");
        int idx = 1;
        if (!getAccounts().isEmpty()) {
            for (Account account : getAccounts()) {
                System.out.printf("%-5s", idx);
                System.out.printf(account.toString());
                idx++;
            }
        }
    }

    public void displayTransactions() {
        int idx = 1;
        if (!getAccounts().isEmpty()) {
            System.out.printf("%-5s %-5s | %20s  | %19s | %36s%n", "[GD]", "Account", "Amount", "Time", "Transaction ID");
            for (Account account : getAccounts()) {
                for (Transaction transaction : account.getTransactions()) {
                    if (idx <= 5) {
                        System.out.printf("%-5s %-5s | %20s  | %19s | %36s%n", "[GD]", account.getAccountNumber()+" ", String.format("%,.0f", transaction.getAmount()) + "đ", transaction.getTime(), transaction.getId());
                        idx++;
                    }
                }
            }
        }
    }
}
