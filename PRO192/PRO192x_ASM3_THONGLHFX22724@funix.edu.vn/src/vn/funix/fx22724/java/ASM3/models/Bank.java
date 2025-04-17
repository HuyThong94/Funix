package vn.funix.fx22724.java.ASM3.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private String id;
    private List<Customer> customers;

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
        if (!isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        } else {
            System.out.println("Khách hàng với CCCD này đã tồn tại!");
        }
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

