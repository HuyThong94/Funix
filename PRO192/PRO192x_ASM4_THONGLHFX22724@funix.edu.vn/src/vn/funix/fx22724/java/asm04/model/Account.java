package vn.funix.fx22724.java.asm04.model;

import vn.funix.fx22724.java.asm04.common.CommonValid;
import vn.funix.fx22724.java.asm04.dao.AccountDao;
import vn.funix.fx22724.java.asm04.dao.CustomerDao;
import vn.funix.fx22724.java.asm04.dao.TransactionDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private double balance;
    private String typeAccount;
    private String customerId;

    public Account() {
        super();
    }

    public Account(String accountNumber, double balance, String typeAccount) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.typeAccount = typeAccount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        // Kiểm tra nếu accountNumber có 6 ký tự số
        if (accountNumber != null && accountNumber.matches("\\d{6}")) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Số tài khoản không hợp lệ! Phải là chuỗi 6 ký tự số.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        List<Transaction> transactions = TransactionDao.list();
        List<Transaction> lstTransaction = new ArrayList<>();
        for(Transaction transaction : transactions) {
            if(transaction.getAccountNumber().equals(this.accountNumber)) {
                lstTransaction.add(transaction);
            }
        }
        lstTransaction.sort(Comparator.comparing(Transaction::getTime).reversed());
        return lstTransaction;
    }

    public boolean isAccountPremium() {
        return balance >= 10000000;
    }

    public Customer getCustomer() {
        List<Customer> lstCustomer = CustomerDao.list();
        for (Customer customer : lstCustomer) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayTransactions(Transaction transaction) {
        System.out.printf("%-5s %-5s | %20s  | %19s %", "[GD]", getAccountNumber(), String.format("%,.2f", transaction.getAmount()) + "đ", transaction.getTime());
    }

    public void displayTransactionsList() {
        for (Transaction transaction : getTransactions()) {
            displayTransactions(transaction);
        }
    }

    public void createTransaction(double amount, String time, boolean status, String type) {
        Transaction transaction = new Transaction(getAccountNumber(), amount, time, status, type);
        List<Transaction> transactions = TransactionDao.list();
        transactions.add(transaction);
        try {
            TransactionDao.save(transactions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void input(Scanner sc) {
        while (true) {
            System.out.print("Nhập số tài khoản gồm 6 chữ số: ");
            String stk = sc.nextLine().trim();
            if (CommonValid.isValidAccountNumber(stk)) {
                setAccountNumber(stk);
                DigitalBank activeBank = new DigitalBank();
                List<Account> lstAccount = AccountDao.list();
                if (activeBank.isAccountExisted(lstAccount, this)) {
                    System.out.print("Nhập số dư tài khoản >= 50000đ: ");
                    String balance = sc.nextLine();
                    if (CommonValid.isValidMoney(balance)) {
                        setTypeAccount("SAVING");
                        setBalance(Double.parseDouble(balance));
                        break;
                    } else {
                        System.out.println("Số dư không hơp lệ. Vui lòng nhập lại. ");
                    }

                } else {
                    System.out.println("Số tài khoản đã có trong hệ thống. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public static String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    @Override
    public String toString() {
        String balanceFormatted = String.format("%,.0f", getBalance()) + "đ";
        return String.format(" %-5s | %32s %20s%n", getAccountNumber(), "", balanceFormatted);
    }
}

