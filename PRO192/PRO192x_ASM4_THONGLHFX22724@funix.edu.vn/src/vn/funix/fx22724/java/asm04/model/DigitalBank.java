package vn.funix.fx22724.java.asm04.model;


import vn.funix.fx22724.java.asm04.dao.CustomerDao;
import vn.funix.fx22724.java.asm04.service.TextFileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalBank extends Bank {
    private final List<DigitalCustomer> customers = new ArrayList<>();

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
        if (lstCustomers.isEmpty()) {
            System.out.println("Chưa có khách hàng nào trong danh sách!");
        } else {
            for (Customer customer : lstCustomers) {
                customer.displayInformation();
            }
        }
    }

    public void addCustomers(String fileName) {
        List<Customer> newCustomers = new ArrayList<>();
        List<Customer> lstCustomers = CustomerDao.list();
        List<List<String>> lstCustomer = TextFileService.readFile(fileName);
        for (List<String> customerTxt : lstCustomer) {
            String customerId = customerTxt.get(0);
            String customerName = customerTxt.get(1);
            boolean isExisted = false;
            for (Customer cus : lstCustomers) {
                if (cus.getCustomerId().equals(customerId)) {
                    isExisted = true;
                    break;
                }
            }

            if (isExisted) {
                System.out.println("Khách hàng" + customerId + "đã tồn tại, thêm khách hàng không thành công");
            } else {
                Customer customer = new Customer(customerName, customerId);
                newCustomers.add(customer); // chỉ lưu KH mới
            }
        }
            try {
                CustomerDao.save(newCustomers);
                for (Customer c : newCustomers) {
                    System.out.println("Đã thêm khách hàng" + c.getCustomerId() + "thành công");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

