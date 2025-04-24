package vn.funix.fx22724.java.asm04;


import vn.funix.fx22724.java.asm04.common.CommonValid;
import vn.funix.fx22724.java.asm04.dao.CustomerDao;
import vn.funix.fx22724.java.asm04.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Asm4 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v3.0.0";
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();

    public static void main(String[] args) {
        getScreen();
    }

    public static void menuScreen() {
        System.out.println(" 1. Danh sách khách hàng");
        System.out.println(" 2. Nhập danh sách khách hàng");
        System.out.println(" 3. Thêm tài khoản ATM");
        System.out.println(" 4. Chuyển tiền");
        System.out.println(" 5. Rút tiền");
        System.out.println(" 6. Tra cứu lịch sử giao dịch");
        System.out.println(" 0. Thoát");
        System.out.println("+----------+--------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }

    public static void getScreen() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  NGÂN HÀNG SỐ | " + AUTHOR + "@" + VERSION + "           |");
        System.out.println("+----------+--------------------+----------+");
        menuScreen();
        int choice = getUserChoice();
        while (true) {
            if (choice == 0) {
                System.out.println("Chương trình kết thúc.");
                System.exit(0);
            } else if (choice == 1) {
                DigitalBank.showCustomers();
                getScreen();
            } else if (choice == 2) {
                handleAddCustomers();
                getScreen();
            } else if (choice == 3) {
                handleAddAccount();
                getScreen();
            } else if (choice == 4) {
                handleTranfers();
                getScreen();
            } else if (choice == 5) {
                handleWithdraw();
                getScreen();
            } else if (choice == 6) {
                transactionHistory();
                getScreen();
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                getScreen();
            }
        }
    }

    private static int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Chọn chức năng: ");
            }
        }
    }

    //chuc nang 2
    private static void handleAddCustomers() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("Nhập đường dẫn đến tệp:");
        String fileName = sc.nextLine();
        activeBank.addCustomers(fileName);
    }

    //chức năng 3
    private static void handleAddAccount() {
        while (true) {
            List<Customer> lstCustomers = CustomerDao.list();
            Customer customer = new Customer();
            System.out.print("Nhập mã số của khách hàng: ");
            String maKH = sc.nextLine();

            if (CommonValid.isValidCustomerId(maKH)) {
                DigitalBank.addSavingAccount(sc, maKH);
                customer.setCustomerId(maKH);
                boolean isCheckCustomer = activeBank.isCustomerExisted(lstCustomers, customer);
                if (isCheckCustomer) {
                    handleAccountNumber(customer);
                    break;
                } else {
                    System.out.println("Mã số khách hàng chưa có trong hệ thống. Vui lòng nhập lại. ");
                }
            } else {
                System.out.println("Mã số khách hàng không hơp lệ. Vui lòng nhập lại");
            }
        }
    }

    private static void handleAccountNumber(Customer customer) {
        while (true) {
            Account newAccount = new Account();
            newAccount.input(sc);
            customer.addAccount(newAccount);
            String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
            newAccount.createTransaction(newAccount.getBalance(), date, true, "DEPOSIT");
            break;
        }
    }

    //Chức năng 4
    private static void handleTranfers() {
        do {
            List<Customer> lstCustomers = CustomerDao.list();
            Customer customer = new Customer();
            System.out.print("Nhập mã số của khách hàng: ");
            String maKH = sc.nextLine();

            if (CommonValid.isValidCustomerId(maKH)) {
                customer.setCustomerId(maKH);
                boolean isCheckCustomer = activeBank.isCustomerExisted(lstCustomers, customer);
                if (isCheckCustomer) {
                    activeBank.tranfers(sc, customer.getCustomerId());
                    break;
                } else {
                    System.out.println("Mã số khách hàng chưa có trong hệ thống. Vui lòng nhập lại. ");
                }
            } else {
                System.out.println("Mã số khách hàng không hơp lệ. Vui lòng nhập lại");
            }
        } while (true);
    }

    //Chức năng 5
    private static void handleWithdraw() {
        do {
            List<Customer> lstCustomers = CustomerDao.list();
            Customer customer = new Customer();
            System.out.print("Nhập mã số của khách hàng: ");
            String maKH = sc.nextLine();

            if (CommonValid.isValidCustomerId(maKH)) {
                customer.setCustomerId(maKH);
                boolean isCheckCustomer = activeBank.isCustomerExisted(lstCustomers, customer);
                if (isCheckCustomer) {
                    activeBank.withdraw(sc, customer.getCustomerId());
                    break;
                } else {
                    System.out.println("Mã số khách hàng chưa có trong hệ thống. Vui lòng nhập lại. ");
                }
            } else {
                System.out.println("Mã số khách hàng không hơp lệ. Vui lòng nhập lại");
            }
        } while (true);
    }

    //Chức năng 6
    private static void transactionHistory() {
        do {
            List<Customer> lstCustomers = CustomerDao.list();
            Customer customer = new Customer();
            System.out.print("Nhập mã số của khách hàng: ");
            String maKH = sc.nextLine();

            if (CommonValid.isValidCustomerId(maKH)) {
                customer.setCustomerId(maKH);
                boolean isCheckCustomer = activeBank.isCustomerExisted(lstCustomers, customer);
                if (isCheckCustomer) {
                    customer = activeBank.getCustomerById(lstCustomers, customer.getCustomerId());
                    customer.displayTransactionInformation();
                    break;
                } else {
                    System.out.println("Mã số khách hàng chưa có trong hệ thống. Vui lòng nhập lại. ");
                }
            } else {
                System.out.println("Mã số khách hàng không hơp lệ. Vui lòng nhập lại");
            }
        } while (true);
    }

}
