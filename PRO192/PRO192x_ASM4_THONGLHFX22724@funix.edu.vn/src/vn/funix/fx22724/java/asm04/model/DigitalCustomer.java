package vn.funix.fx22724.java.asm04.model;

import java.util.ArrayList;
import java.util.List;

public class DigitalCustomer extends Customer {
    public DigitalCustomer(){
        super();
    }
    public void addAccount(Account account) {
        if (getAccountByAccountNumber(account.getAccountNumber()) != null) {
            System.out.println("Tài khoản đã tồn tại!");
            return;
        }
        List<Account> accountList = new ArrayList<>();
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
            return false;
        }
    }

    public boolean transfers(String reveiveAccount, double amount) {
        Account account = getAccountByAccountNumber(reveiveAccount);
        if (account == null) {
            System.out.println("Tài khoản không tồn tại!");
            return false;
        }
        if (account.getTypeAccount().equals("SAVINGS")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            return savingsAccount.transfers(amount, account);
        } else {
            return false;
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
        System.out.printf("%-12s | %20s | %7s | %" + (String.format("%,.2f", getTotalAccountBalance()) + "đ").length() + "s%n", getCustomerId(), getName(), (isCustomerPremium() ? "Premium" : "Normal"), (String.format("%,.2f", getTotalAccountBalance()) + "đ"));
        int idx = 1;
        if (!getAccounts().isEmpty()) {
            for (Account account : getAccounts()) {
                System.out.printf("%-5s %-5s | %12s %7s | %9s %" + (String.format("%,.2f", getTotalAccountBalance()) + "đ").length() + "s%n", idx + ".", account.getAccountNumber(), "", account.getTypeAccount(), "", (String.format("%,.2f", account.getBalance()) + "đ"));
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
                        System.out.printf("%-5s %-5s | %20s  | %19s | %36s%n", "[GD]", account.getAccountNumber(), String.format("%,.2f", transaction.getAmount()) + "đ", transaction.getTime(), transaction.getId());
                        idx++;
                    }
                }
            }
        }
    }
}
