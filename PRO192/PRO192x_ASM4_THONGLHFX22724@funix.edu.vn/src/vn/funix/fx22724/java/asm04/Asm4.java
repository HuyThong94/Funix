package vn.funix.fx22724.java.asm04;


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
//                handleAddAccount(sc, "LOAN");
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

    private static void handleAddCustomers(Scanner scanner) {
        List<Customer> customers = new ArrayList<>();
        System.out.println("+----------+--------------------+----------+");
        System.out.println("Nhập đường dẫn đến tệp:");
        String fileName = sc.nextLine();
        activeBank.addCustomers(fileName);
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

    private static boolean validateAccount(String accountNumber) {
        return accountNumber.length() == 6 && accountNumber.matches("\\d{6}");
    }

    private static boolean isValidMoney(String money) {
        boolean validMoney = Double.parseDouble(money) >= 50000 && money.matches("\\d+");
        return validMoney;
    }
}
