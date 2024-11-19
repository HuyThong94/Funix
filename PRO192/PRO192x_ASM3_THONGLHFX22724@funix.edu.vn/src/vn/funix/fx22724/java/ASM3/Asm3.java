package vn.funix.fx22724.java.ASM3;

import vn.funix.fx22724.java.ASM2.models.Account;
import vn.funix.fx22724.java.ASM2.models.Customer;
import vn.funix.fx22724.java.ASM3.models.DigitalBank;
import vn.funix.fx22724.java.ASM3.models.DigitalCustomer;
import vn.funix.fx22724.java.ASM3.models.LoanAccount;
import vn.funix.fx22724.java.ASM3.models.SavingsAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asm3 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v3.0.0";
    private static final int EXIT_COMMAND = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "042094005195";
    private static final String CUSTOMER_NAME = "Luong Huy Thong";
    private static final List<Account> accounts = new ArrayList<>();


    public static void main(String[] args) {
        activeBank.addCustomer(CUSTOMER_ID, CUSTOMER_NAME, accounts);
        getScreen(sc);
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

    public static void getScreen(Scanner sc) {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  NGÂN HÀNG SỐ | " + AUTHOR + "@" + VERSION + "           |");
        System.out.println("+----------+--------------------+----------+");
        menuScreen();
        int choice = getUserChoice(sc);
        while (true) {
            Customer customer = new Customer();
            if (choice == 0) {
                System.out.println("Chương trình kết thúc.");
                break;
            } else if (choice == 1) {
                getCustomerInformation();
                getScreen(sc);
            } else if (choice == 2) {
                handleAddAccount(sc, "SAVINGS");
                getScreen(sc);
            } else if (choice == 3) {
                handleAddAccount(sc, "LOAN");
                getScreen(sc);
            } else if (choice == 4) {
                handleWithdrawMoney(sc);
                getScreen(sc);
            } else if (choice == 5) {
                handleCustomerByName(sc);
                getScreen(sc);
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                getScreen(sc);
            }
        }
    }

    //Chức năng 1
    private static void getCustomerInformation() {
        DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
        }
    }

    //chức năng 2, 3
    private static void handleAddAccount(Scanner sc, String type) {
        Account account = new Account();
        while (true) {
            System.out.print("Nhập mã số tài khoản gồm 6 chữ số: ");
            String stk = sc.nextLine().trim();
            if (isValidSTK(stk)) {
                boolean ischeckStk = false;
                for (int i = 0; i < activeBank.getCustomers().size(); i++) {
                    Customer cus = activeBank.getCustomers().get(i);
                    for (int j = 0; j < cus.getAccounts().size(); j++) {
                        Account acc = cus.getAccounts().get(j);
                        if (acc.getAccountNumber().equals(stk)) {
                            ischeckStk = true;
                            break;
                        }
                    }

                }
                if (!ischeckStk) {
                    account.setAccountNumber(stk);
                    System.out.print("Nhập số dư: ");
                    double balance = getBalance(sc);
                    account.setBalance(balance);
                    DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
                    if (type == "LOAN") {
                        customer.addAccount(new LoanAccount(stk, balance, type));
                    } else {
                        customer.addAccount(new SavingsAccount(stk, balance, type));
                    }
                    System.out.println("Đã thêm số tài khoản: " + stk + " với số dư là: " + (String.format("%,.0f", balance) + "đ") + " vào danh sách");
                    break;
                } else {
                    System.out.println("Số tài khoản đã có trong hệ thống. Vui lòng nhập lại: ");
                }
            } else {
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    //chức năng 4
    private static void handleWithdrawMoney(Scanner sc) {
        System.out.println(" 1. Rút tiền từ tìa khoản ATM");
        System.out.println(" 2. Rút tiền từ tài khoản tín dụng");
        System.out.print("Chọn chức năng: ");
        int choice = getUserChoice(sc);
        while (true) {
            if (choice == 1) {
                getCustomerInformation();
                getScreen(sc);
            } else if (choice == 2) {
                getScreen(sc);
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                getScreen(sc);
            }
        }
    }

    //Chức năng 4.1 ATM
    private static void handleWithdrawATM(Scanner sc, String type) {
        while (true) {
        System.out.println("+----------+--------------------+----------+");
            System.out.print("Nhập số tiền: ");
            double balance = sc.nextDouble();
        }
    }

    //chức năng 5
    private static void handleCustomerByName(Scanner sc) {
        while (true) {
            System.out.print("Nhập tên khách hàng: ");
            String searchName = sc.nextLine();
            boolean found = false;
            for (Customer customer : activeBank.getCustomers()) {
                if (customer.getName().toLowerCase().contains(searchName.toLowerCase())) {
                    customer.displayInformation();
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            } else {
                System.out.println("Không tìm thấy khách hàng phù hợp.");
                break;
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

    private static double getBalance(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
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

}
