package vn.funix.fx22724.java.ASM3;

import vn.funix.fx22724.java.ASM3.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asm3 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v3.0.0";
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "042094005195";
    private static final String CUSTOMER_NAME = "Luong Huy Thong";
    private static final List<Account> accounts = new ArrayList<>();
    private static DigitalCustomer customer = new DigitalCustomer();

    public static void main(String[] args) {
        activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME, accounts);
        getScreen();
    }

    public static void menuScreen() {
        System.out.println(" 1. Thông tin khách hàng");
        System.out.println(" 2. Thêm tài khoản ATM");
        System.out.println(" 3. Thêm tài khoản tín dụng");
        System.out.println(" 4. Rút tiền");
        System.out.println(" 5. Lịch sử giao dịch");
        System.out.println(" 0. Thoát");
        System.out.println("+----------+--------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }

    public static void getScreen() {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  NGÂN HÀNG SỐ | " + AUTHOR + "@" + VERSION + "           |");
        System.out.println("+----------+--------------------+----------+");
        while (true) {
            menuScreen();
            int choice = getUserChoice();
            switch (choice){
                case 1:
                    showCustomer();
                    break;
                case 2:
                    handleAddAccount("SAVINGS");
                    break;
                case 3:
                    handleAddAccount("LOAN");
                    break;
                case 4:
                    handleWithdrawMoney();
                    break;
                case 5:
                    handleTransaction();
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        }
    }

    //Chức năng 1
    private static void showCustomer() {
        customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
        }
    }

    //chức năng 2, 3
    private static void handleAddAccount(String type) {
        while (true) {
            System.out.print("Nhập mã số tài khoản gồm 6 chữ số: ");
            String accountNumber = sc.nextLine().trim();
            if (validateAccount(accountNumber)) {
                boolean isCheckAccountNumber = false;
                DigitalCustomer cus = activeBank.getCustomerById(CUSTOMER_ID);
                for (int j = 0; j < cus.getAccounts().size(); j++) {
                    Account acc = cus.getAccounts().get(j);
                    if (acc.getAccountNumber().equals(accountNumber)) {
                        isCheckAccountNumber = true;
                        break;
                    }
                }
                if (!isCheckAccountNumber) {
                    handleEnterMoney(accountNumber, type);
                    break;
                } else {
                    System.out.println("Số tài khoản đã có trong hệ thống. Vui lòng nhập lại: ");
                }
            } else {
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    private static void handleEnterMoney(String accountNumber, String type) {
        while (true) {
            DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
            System.out.print("Nhập số tiền: ");
            String balance = getBalance();

            if (isValidMoney(balance)) {
                if (type.equals("LOAN")) {
                    customer.addAccount(new LoanAccount(accountNumber, Double.parseDouble(balance), type));
                } else {
                    customer.addAccount(new SavingsAccount(accountNumber, Double.parseDouble(balance), type));
                }
                System.out.println("Đã thêm số tài khoản: " + accountNumber + " với số dư là: " + (String.format("%,.0f", Double.parseDouble(balance)) + "đ") + " vào danh sách");
                break;
            }else{
                System.out.println("Số dư không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    //chức năng 4
    private static void handleWithdrawMoney() {
        boolean isWithdraw;
        DigitalCustomer digitalCustomer = activeBank.getCustomerById(CUSTOMER_ID);
        List<Account> acc = digitalCustomer.getAccounts();
        System.out.println("+----------+--------------------+----------+");
        if (!acc.isEmpty()) {
            while (true) {
                showCustomer();
                System.out.print("Chọn tài khoản: ");
                int idx = getSTK();
                if ((idx - 1) < acc.size()) {
                    System.out.print("Nhập số tiền: ");
                    double amount = Double.parseDouble(getBalance());

                    activeBank.withdraw(CUSTOMER_ID, acc.get(idx - 1).getAccountNumber(), amount);
//                    if (isWithdraw) {
                    break;
//                    }
                } else {
                    System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                }
            }
        } else {
            System.out.println("Danh sách tài khoản của trống.");
        }
    }

    //chức năng 5
    private static void handleTransaction() {
        System.out.println("+----------+--------------------+----------+");
        customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
            System.out.println();
            customer.displayTransactions();
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

    private static int getSTK() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Chọn tài khoản: ");
            }
        }
    }

    private static String getBalance() {
        while (true) {
            try {
                return sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Chọn chức năng: ");
            }
        }
    }

    private static boolean validateAccount(String accountNumber) {
        return accountNumber.length() == 6 && accountNumber.matches("\\d{6}");
    }

    private static boolean isValidMoney(String money) {
        boolean validMoney = Double.parseDouble(money)>=50000 && money.matches("\\d+");
        return validMoney;
    }
}
