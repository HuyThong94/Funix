package vn.funix.fx22724.java.asm04.model;

import vn.funix.fx22724.java.asm04.common.CommonValid;
import vn.funix.fx22724.java.asm04.dao.AccountDao;
import vn.funix.fx22724.java.asm04.dao.CustomerDao;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();
    private String typeAccount;
    private String customerId;

    public Account() {
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean isAccountPremium() {
        return balance >= 10000000;
    }

    @Override
    public String toString() {
        return accountNumber + " | " + String.format("%,.2f", balance) + "đ";
    }

    public static String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
    public Customer getCustomer(){
        List<Customer> lstCustomer = CustomerDao.list();
        for (Customer customer : lstCustomer) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public List<Transaction> displayTransactionsList(){
        return transactions;
    }
    public void createTransaction(double amount, String time, boolean status, String type){
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTime(time);
        transaction.setStatus(status);

    }
    public void input(Scanner sc){
        while (true) {
            System.out.print("Nhập số tài khoản gồm 6 chữ số: ");
            String stk = sc.nextLine().trim();
            if (CommonValid.isValidAccountNumber(stk)) {
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
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

