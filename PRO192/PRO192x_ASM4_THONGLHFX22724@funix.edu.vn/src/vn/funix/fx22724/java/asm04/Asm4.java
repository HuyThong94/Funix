package vn.funix.fx22724.java.asm04;


import vn.funix.fx22724.java.asm04.common.CommonValid;
import vn.funix.fx22724.java.asm04.dao.AccountDao;
import vn.funix.fx22724.java.asm04.dao.CustomerDao;
import vn.funix.fx22724.java.asm04.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asm4 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v3.0.0";
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();

    public static void main(String[] args) {
        getScreen(sc);
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

    public static void getScreen(Scanner sc) {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  NGÂN HÀNG SỐ | " + AUTHOR + "@" + VERSION + "           |");
        System.out.println("+----------+--------------------+----------+");
        menuScreen();
        int choice = getUserChoice(sc);
        while (true) {
            if (choice == 0) {
                System.out.println("Chương trình kết thúc.");
                break;
            } else if (choice == 1) {
                DigitalBank.showCustomers();
                getScreen(sc);
            } else if (choice == 2) {
                handleAddCustomers(sc);
                getScreen(sc);
            } else if (choice == 3) {
                handleAddAccount(sc);
                getScreen(sc);
            } else if (choice == 4) {
                handleTranfers(sc);
                getScreen(sc);
            } else if (choice == 5) {
//                handleTransaction(sc);
                getScreen(sc);
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                getScreen(sc);
            }
        }
    }

    private static int getUserChoice(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Chọn chức năng: ");
            }
        }
    }

    //chuc nang 2
    private static void handleAddCustomers(Scanner scanner) {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("Nhập đường dẫn đến tệp:");
        String fileName = sc.nextLine();
        activeBank.addCustomers(fileName);
    }

    //chức năng 3
    private static void handleAddAccount(Scanner sc) {
        while (true) {
            List<Customer> lstCustomers = CustomerDao.list();
            Customer customer = new Customer();
            System.out.print("Nhập mã số của khách hàng: ");
            String maKH = sc.nextLine();

            if (CommonValid.isValidCustomerId(maKH)) {
                customer.setCustomerId(maKH);
                boolean isCheckCustomer = activeBank.isCustomerExisted(lstCustomers, customer);
                if (isCheckCustomer) {
                    handleAccountNumber(sc, customer);
                    break;
                } else {
                    System.out.println("Mã số khách hàng chưa có trong hệ thống. Vui lòng nhập lại. ");
                }
            } else {
                System.out.println("Mã số khách hàng không hơp lệ. Vui lòng nhập lại");
            }
        }
    }

    private static void handleAccountNumber(Scanner sc, Customer customer) {
        while (true) {
            Account newAccount = new Account();
                List<Account> lstAccount = AccountDao.list();
                newAccount.setCustomerId(customer.getCustomerId());
                newAccount.input(sc);
                lstAccount.add(newAccount);
                try {
                    AccountDao.save(lstAccount);
                    System.out.println("tạo tài khoản thành công");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
    //Chức năng 4
    private static void handleTranfers(Scanner sc) {
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

    public static void handleEnterAccountNumberSend(Scanner sc, Customer customer) {
        while (true) {
            System.out.print("Nhập số tài khoản: ");
            String stk = sc.nextLine().trim();
            if (CommonValid.isValidAccountNumber(stk)) {
                Account newAccount = new Account();
                newAccount.setAccountNumber(stk);
                if (activeBank.isAccountExisted(customer.getAccounts(), newAccount)) {
                    handleEnterRecipientAccountNumber(sc, stk, customer);
                    break;
                } else {
                    System.out.println("Số tài khoản chưa có trong hệ thống. Vui lòng nhập lại: ");
                }
            } else {
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    private static void handleEnterRecipientAccountNumber(Scanner sc, String sendStk, Customer customer) {
        while (true) {
            System.out.print("Nhập số tài khoản nhận( exit để thoát): ");
            String recipientStk = sc.nextLine().trim();
            if (recipientStk.equalsIgnoreCase("exit")) {
                System.out.println("Thoát chương trình!");
                break;
            }

            if (CommonValid.isValidAccountNumber(recipientStk)) {
                Account newAccount = new Account();
                newAccount.setAccountNumber(recipientStk);
                if (activeBank.isAccountExisted(customer.getAccounts(), newAccount)) {
                    handleEnterMoneyTranfers(sc, recipientStk, sendStk, customer);
                    break;
                } else {
                    System.out.println("Số tài khoản chưa có trong hệ thống. Vui lòng nhập lại: ");
                }
            } else {
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    private static void handleEnterMoneyTranfers(Scanner sc, String reveiveAccount, String sendStk, Customer customer) {
        while (true) {
            System.out.print("Nhập số tiền chuyển ");
            String amount = sc.nextLine();
            if (CommonValid.isValidMoneyTranfers(amount)) {
                System.out.println("Xác nhận thực hiện chuyển " + (String.format("%,.2f", Double.parseDouble(amount)) + "đ") + "từ tài khoản [" + sendStk + "] đến tài khoản [" + reveiveAccount + "] (Y/N): ");
                String status = sc.nextLine().trim();
                if (status.equalsIgnoreCase("Y")) {
//                    boolean isTransfers = activeBank.transfers(customer, reveiveAccount, sendStk, Double.parseDouble(amount));
                } else if (status.equalsIgnoreCase("N")) {
                    getScreen(sc);
                } else {
                    System.out.println("Dữ liệu không hơp lệ. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Số dư không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

}
