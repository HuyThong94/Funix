package vn.funix.fx22724.java.asm04.model;


import vn.funix.fx22724.java.asm04.Asm4;
import vn.funix.fx22724.java.asm04.dao.CustomerDao;
import vn.funix.fx22724.java.asm04.service.TextFileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalBank extends Bank {

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
            Customer customer = new Customer(customerTxt);
            boolean isExisted = false;
            for (Customer cus : lstCustomers) {
                if (cus.getCustomerId() != null && cus.getCustomerId().equals(customer.getCustomerId())) {
                    isExisted = true;
                    break;
                }
            }

            if (isExisted) {
                System.out.println("Khách hàng " + customer.getCustomerId() + " đã tồn tại, thêm khách hàng không thành công");
            } else {
                lstCustomers.add(customer); // chỉ lưu KH mới
                newCustomers.add(customer); // chỉ lưu KH mới
            }
        }
        try {
            CustomerDao.save(lstCustomers);
            for (Customer c : newCustomers) {
                System.out.println("Đã thêm khách hàng " + c.getCustomerId() + " thành công");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addSavingAccount(Scanner sc, String customerId) {

    }

    public void withdraw(Scanner sc, String customerId) {
        List<Customer> lstCustomers = CustomerDao.list();
        Customer customer = getCustomerById(lstCustomers, customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
        }
    }

    public void tranfers(Scanner sc, String customerId) {
        List<Customer> lstCustomers = CustomerDao.list();
        Customer customer = getCustomerById(lstCustomers, customerId);
        customer.displayInformation();
        customer.transfers(sc);
    }

    public boolean isAccountExisted(List<Account> accountList, Account newAccount) {
        String accountNumber = newAccount.getAccountNumber();
        boolean isCheckStk = true;
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                isCheckStk = false;
                break;
            }
        }
        return isCheckStk;
    }

    public static boolean isCustomerExisted(List<Customer> customers, Customer newCustomer) {
        String customerId = newCustomer.getCustomerId();
        boolean isCheckCustomer = false;

        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                isCheckCustomer = true;
                break;
            }
        }

        return isCheckCustomer;
    }

    public Customer getCustomerById(List<Customer> customers, String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
}

