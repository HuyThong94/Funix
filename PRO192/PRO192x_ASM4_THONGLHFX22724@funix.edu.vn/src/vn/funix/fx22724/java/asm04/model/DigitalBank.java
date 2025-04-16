package vn.funix.fx22724.java.asm04.model;


import vn.funix.fx22724.java.asm04.dao.CustomerDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalBank extends Bank {
    private final List<DigitalCustomer> customers = new ArrayList<>();

    public void addCustomer(String customerId, String name, List<Account> accounts) {
        if (getCustomerById(customerId) != null) {
            System.out.println("Khách hàng đã tồn tại!");
            return;
        }
        customers.add(new DigitalCustomer(customerId, name, accounts));
        System.out.println("Thêm khách hàng thành công!");
    }

    public DigitalCustomer getCustomerById(String customerId) {
        for (DigitalCustomer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public boolean withdraw(String customerId, String accountNumber, double amount) {
        DigitalCustomer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return false;
        }
        return customer.withdraw(accountNumber, amount);
    }

    public static void showCustomers() {
        List<Customer> lstCustomers = CustomerDao.list();
        for (Customer customer : lstCustomers) {
            customer.displayInformation();
        }
    }

    public void addCustomer(String fileName) {

    }

    public void addSavingAccount(Scanner sc, String customerId) {

    }

    public void tranfers(Scanner sc, String customerId) {
    }

    public boolean isAccountExisted(List<Account> accountList, Account newAccount) {
        return false;
    }

    public boolean isCustomerExisted(List<Customer> customers, Account newAccount) {
        return false;
    }

    public void getCustomerById(List<Customer> customers, String customerId) {
    }
}

