package vn.funix.fx22724.java.asm04.model;

import java.util.ArrayList;
import java.util.List;

public class DigitalCustomer extends Customer {
    private static List<Account> accounts = new ArrayList<>();

    public DigitalCustomer() {
    }

    public DigitalCustomer(String customerId, String name, List<Account> accounts) {
        super(name, customerId);
        DigitalCustomer.accounts = accounts;
    }

    public static List<Account> getAccounts() {
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
//            LoanAccount loanAccount = (LoanAccount) account;
            return false;
        }

    }

    @Override
    public double getTotalAccountBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    @Override
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

    public void displayTransactions() {
        int idx = 1;
        if (!accounts.isEmpty()) {
            System.out.printf("%-5s %-5s | %20s  | %19s | %36s%n", "[GD]", "Account", "Amount", "Time", "Transaction ID");
            for (Account account : accounts) {
                for (Transaction transaction : account.getTransactions()) {
                    if (idx <= 5) {
                        System.out.printf("%-5s %-5s | %20s  | %19s | %36s%n", "[GD]", account.getAccountNumber(), String.format("%,.0f", transaction.getAmount()) + "đ", transaction.getTime(), transaction.getId());
                        idx++;
                    }
                }
            }
        }
    }
}
