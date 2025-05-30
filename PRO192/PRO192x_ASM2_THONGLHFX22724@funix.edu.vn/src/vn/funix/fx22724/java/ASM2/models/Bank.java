package vn.funix.fx22724.java.ASM2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private final String id;
    private final List<Customer> customers;

    public Bank() {
        // Tạo ID ngẫu nhiên cho ngân hàng
        this.id = String.valueOf(UUID.randomUUID());
        this.customers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addCustomer(Customer newCustomer) {
        // Chỉ thêm khách hàng nếu CCCD chưa tồn tại
        if (isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        } else {
            System.out.println("Khách hàng với CCCD này đã tồn tại!");
        }
    }

    public void addAccount(String customerId, Account account) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.addAccount(account);
            }
        }
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return false;
            }
        }
        return true;
    }

    public Customer getCustomerById(String customerId) {
        Customer customer = new Customer();
        for (Customer cus : getCustomers()) {
            if (cus.getCustomerId().equals(customerId)) {
                customer = cus;
            }
        }
        return customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

