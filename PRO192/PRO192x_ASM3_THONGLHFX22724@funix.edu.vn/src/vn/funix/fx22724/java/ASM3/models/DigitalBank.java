package vn.funix.fx22724.java.ASM3.models;

import vn.funix.fx22724.java.ASM2.models.Account;
import vn.funix.fx22724.java.ASM2.models.Bank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalBank extends Bank {
    private List<DigitalCustomer> customers = new ArrayList<>();

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

    public void addSavingsAccount(String customerId, Scanner scanner) {
        DigitalCustomer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
        System.out.print("Nhập số tài khoản (6 chữ số): ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập số dư ban đầu: ");
        double balance = scanner.nextDouble();
        customer.addAccount(new SavingsAccount(accountNumber, balance, "SAVINGS"));
    }

    public void addLoanAccount(String customerId, Scanner scanner) {
        DigitalCustomer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
        System.out.print("Nhập số tài khoản (6 chữ số): ");
        String accountNumber = scanner.nextLine();
        System.out.print("Nhập hạn mức tín dụng: ");
        double limit = scanner.nextDouble();
        customer.addAccount(new LoanAccount(accountNumber, limit, "LOAN"));
    }

    public void withdraw(String customerId, String accountNumber, double amount) {
        DigitalCustomer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
        customer.withdraw(accountNumber, amount);
    }

    public void displayTransactionHistory(String customerId) {
        DigitalCustomer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
        customer.displayTransactionHistory();
    }

    public void displayCustomerInformation(String customerId) {
        DigitalCustomer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
        customer.displayInformation();
    }
}

