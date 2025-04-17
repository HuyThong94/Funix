package vn.funix.fx22724.java.asm04;


import vn.funix.fx22724.java.asm04.dao.AccountDao;
import vn.funix.fx22724.java.asm04.dao.CustomerDao;
import vn.funix.fx22724.java.asm04.model.*;
import vn.funix.fx22724.java.asm04.service.BinaryFileService;
import vn.funix.fx22724.java.asm04.service.TextFileService;

import java.io.File;
import java.io.FileNotFoundException;
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
//                handleWithdrawMoney(sc);
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
        List<Customer> customers = new ArrayList<>();
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

            if (isValidCCCD(maKH)) {
                boolean isCheckCustomer = false;
                for (Customer cus : lstCustomers) {
                    if (cus.getCustomerId().equals(maKH)) {
                        isCheckCustomer = true;
                        customer = cus;
                        break;
                    }
                }
                if (isCheckCustomer) {
                    handleAccountNumber(sc, customer, lstCustomers);
                    break;
                } else {
                    System.out.println("Số CCCD chưa có trong hệ thống. Vui lòng nhập lại. ");
                }
            } else {
                System.out.println("Số CCCD không hơp lệ. Vui lòng nhập lại");
            }
        }
    }

    private static void handleAccountNumber(Scanner sc, Customer customer, List<Customer> lstCustomers) {
        while (true) {
            System.out.print("Nhập số tài khoản gồm 6 chữ số: ");
            String stk = sc.nextLine().trim();
            if (isValidSTK(stk)) {
                if (!isIsCheckStk(stk, customer.getAccounts())) {
                    handleEnterMoney(sc, stk, customer, lstCustomers);
                    break;
                } else {
                    System.out.println("Số tài khoản đã có trong hệ thống. Vui lòng nhập lại: ");
                }
            } else {
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    private static void handleEnterMoney(Scanner sc, String stk, Customer customer, List<Customer> lstCustomers) {
        while (true) {
            Account account = new Account();
            account.setAccountNumber(stk);
            System.out.print("Nhập số dư tài khoản >= 50000đ: ");
            String balance = getBalance(sc);
            if (isValidMoney(balance)) {
                List<Account> lstAccount = AccountDao.list();
                account.setBalance(Double.parseDouble(balance));
                lstAccount.add(account);
                try {
                    AccountDao.save(lstAccount);
                    System.out.println("tạo tài khoản thành công");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            } else {
                System.out.println("Số dư không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    private static boolean isIsCheckStk(String stk, List<Account> accounts) {
        boolean isCheckStk = false;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(stk)) {
                isCheckStk = true;
                break;
            }
        }
        return isCheckStk;
    }

    private static String getBalance(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Chọn chức năng: ");
            }
        }
    }

    private static boolean isValidCCCD(String cccd) {
        return cccd.length() == 12 && cccd.matches("\\d{12}");
    }

    private static boolean isValidSTK(String cccd) {
        return cccd.length() == 6 && cccd.matches("\\d{6}");
    }

    private static boolean isValidMoney(String money) {
        return Double.parseDouble(money) >= 50000 && money.matches("\\d+");
    }

    private static boolean validateAccount(String accountNumber) {
        return accountNumber.length() == 6 && accountNumber.matches("\\d{6}");
    }

}
