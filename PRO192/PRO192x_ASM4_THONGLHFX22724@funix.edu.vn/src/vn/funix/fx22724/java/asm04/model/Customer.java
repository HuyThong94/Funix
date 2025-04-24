package vn.funix.fx22724.java.asm04.model;

import vn.funix.fx22724.java.asm04.common.CommonValid;
import vn.funix.fx22724.java.asm04.dao.AccountDao;

import java.io.IOException;
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

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        List<Account> lstAccount = AccountDao.list();
        if (!lstAccount.isEmpty()) {
            for (Account account : lstAccount) {
                if (account.getCustomerId().equals(this.getCustomerId())) {
                    accounts.add(account);
                }
            }
        }
        return accounts;
    }

    public boolean isCustomerPremium() {
        // Kiểm tra nếu ít nhất một tài khoản của khách hàng là premium
        boolean isAccountPremium = false;
        List<Account> accounts = getAccounts();
        if (!accounts.isEmpty()) {
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
        List<Account> accountLst = getAccounts();
        List<Account> accountList = AccountDao.list();
        for (Account account : accountLst) {
            if (account.getAccountNumber().equals(newAccount.getAccountNumber())) {
                System.out.println("Tài khoản đã tồn tại!");
                return;
            }
        }
        newAccount.setCustomerId(getCustomerId());
        accountList.add(newAccount);
        try {
            AccountDao.save(accountList);
            System.out.println("tạo tài khoản thành công");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double getTotalAccountBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void displayInformation() {
        System.out.printf("%-12s | %20s | %7s | %20s%n", getCustomerId(), getName(), (isCustomerPremium() ? "Premium" : "Normal"), (String.format("%,.2f", getTotalAccountBalance()) + "đ"));
        int idx = 1;
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.printf("%-5s", idx);
                System.out.printf(account.toString());
                idx++;
            }
        }

    }

    public Account getAccountByAccountNumber(List<Account> accounts, String accountNumber) {
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }
        return null;
    }

    public void displayTransactionInformation() {
        int idx = 1;
        System.out.printf("%-12s | %20s | %7s | %20s%n", getCustomerId(), getName(), (isCustomerPremium() ? "Premium" : "Normal"), (String.format("%,.2f", getTotalAccountBalance()) + "đ"));
        if (!accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.printf("%-5s", idx);
                System.out.printf(account.toString());
                idx++;
            }
            for (Account account : accounts) {
                account.displayTransactionsList();
            }
        }
    }

    public void withdraw(Scanner scanner) {
        List<Account> accounts = getAccounts();
        if (!accounts.isEmpty()) {
            Account account;
            double amount;
            do {
                System.out.println("Nhập số tài khoản: ");
                String stk = scanner.nextLine();
                if (CommonValid.isValidAccountNumber(stk)) {
                    account = getAccountByAccountNumber(accounts, stk);
                } else {
                    System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại.");
                    account = null;
                }
            } while (account == null);
            do {
                System.out.println("Nhập số tiền rút: ");
                amount = Double.parseDouble(scanner.nextLine());
            } while (amount <= 0);
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).withdraw(amount);
            }
        } else {
            System.out.println("Khách hàng không có tài khoản nào, thao tác không thành công");
        }
    }

    public void transfers(Scanner scanner) {
        List<Account> accounts = AccountDao.list();
        if (!accounts.isEmpty()) {
            double amount;
            Account accountSend;
            Account accountReveive;
            do {
                System.out.println("Nhập số tài khoản: ");
                String stk = scanner.nextLine();
                if (CommonValid.isValidAccountNumber(stk)) {
                    accountSend = getAccountByAccountNumber(accounts, stk);
                } else {
                    System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại.");
                    accountSend = null;
                }
            } while (accountSend == null);
            do {
                System.out.println("Nhập số tài khoản nhận( exit để thoát): ");
                String reveiveAccountNumber = scanner.nextLine();
                if (reveiveAccountNumber.equalsIgnoreCase("exit")) {
                    System.out.println("Thoát chương trình!");
                    accountReveive = null;
                    break;
                }
                if (CommonValid.isValidAccountNumber(reveiveAccountNumber)) {
                    accountReveive = getAccountByAccountNumber(accounts, reveiveAccountNumber);
                    Customer customerReveive = accountReveive.getCustomer();
                    System.out.println("Gửi tiền đến tài khoản: " + reveiveAccountNumber + " | " + customerReveive.getName());
                } else {
                    System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
                    accountReveive = null;
                }
            } while (accountReveive == null);
            do {
                System.out.println("Nhập số tiền chuyển: ");
                amount = Double.parseDouble(scanner.nextLine());
            } while (amount <= 0);
            if (accountSend instanceof SavingsAccount && accountReveive instanceof SavingsAccount) {
                ((SavingsAccount) accountSend).transfers(amount, accountReveive);
            }
        } else {
            System.out.println("Khách hàng không có tài khoản nào, thao tác không thành công");
        }
    }

}

