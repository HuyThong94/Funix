package vn.funix.fx22724.java.ASM2;

import vn.funix.fx22724.java.ASM2.models.Account;
import vn.funix.fx22724.java.ASM2.models.Bank;
import vn.funix.fx22724.java.ASM2.models.Customer;

import java.util.Scanner;

public class Asm2 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v2.0.0";
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getScreen(sc);
    }

    public static void menuScreen() {
        System.out.println(" 1. Thêm khách hàng");
        System.out.println(" 2. Thêm tài khoản cho khách hàng");
        System.out.println(" 3. Hiển thị danh sách khách hàng");
        System.out.println(" 4. Tìm theo CCCD");
        System.out.println(" 5. Tìm theo tên khách hàng");
        System.out.println(" 0. Thoát");
        System.out.println("+----------+--------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }

    public static void getScreen(Scanner sc) {
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  NGÂN HÀNG SỐ | " + AUTHOR + "@" + VERSION + "           |");
        System.out.println("+----------+--------------------+----------+");
        while (true) {

            menuScreen();
            int choice = getUserChoice(sc);
            switch (choice) {
                case 1:
                    handleCCCDInput(sc);
                    break;
                case 2:
                    handleAccount(sc);
                    break;
                case 3:
                    handleListCustomer();
                    break;
                case 4:
                    handleCustomerByCCCD(sc);
                    break;
                case 5:
                    handleCustomerByName(sc);
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    //Chức năng 1
    private static void handleCCCDInput(Scanner scanner) {
        Customer customer = new Customer();
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        customer.setName(name);
        // Nhập CCCD
        while (true) {
            System.out.print("Nhập số CCCD: ");
            String cccd = scanner.nextLine().trim();

            if (cccd.equalsIgnoreCase("No")) {
                System.out.println("Thoát chương trình!");
                break;
            }

            if (isValidCCCD(cccd)) {
                // Nếu CCCD hợp lệ, thực hiện các chức năng tiếp theo
                if (bank.isCustomerExisted(cccd)) {
                    customer.setCustomerId(cccd);
                    System.out.println("Đã thêm khách hàng " + customer.getCustomerId() + " vào danh sách");
                    bank.addCustomer(customer);
                    break;
                } else {
                    System.out.println("Số CCCD đã có trong hệ thống. Vui lòng nhập lại hoặc 'No' để thoát.");
                }
            } else {
                System.out.println("Số CCCD không hơp lệ. Vui lòng nhập lại hoặc ‘No’ để thoát:");
            }
        }
    }

    //chức năng 2
    private static void handleAccount(Scanner sc) {
        while (true) {
            System.out.print("Nhập CCCD khách hàng: ");
            String checkCCCD = sc.nextLine();
            if (checkCCCD.equalsIgnoreCase("No")) {
                System.out.println("Thoát chương trình!");
                break;
            }
            if (!bank.isCustomerExisted(checkCCCD)) {
                Customer customer = bank.getCustomerById(checkCCCD);
                handleAccountNumber(sc, customer);
                break;
            } else {
                System.out.println("Số CCCD chưa có trong hệ thống. Vui lòng nhập lại hoặc 'No' để thoát. ");
            }
        }
    }

    private static void handleAccountNumber(Scanner sc, Customer customer) {
        while (true) {
            System.out.print("Nhập mã số tài khoản gồm 6 chữ số: ");
            String stk = sc.nextLine().trim();
            if (isValidSTK(stk)) {
                if (!isIsCheckStk(stk)) {
                    handleEnterMoney(sc, stk, customer);
                    break;
                } else {
                    System.out.println("Số tài khoản đã có trong hệ thống. Vui lòng nhập lại: ");
                }
            } else {
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    private static void handleEnterMoney(Scanner sc, String stk, Customer customer) {
        while (true) {
            Account account = new Account();
            account.setAccountNumber(stk);
            System.out.print("Nhập số dư: ");
            String balance = getBalance(sc);
            if (isValidMoney(balance)) {
                account.setBalance(Double.parseDouble(balance));
                bank.addAccount(customer.getCustomerId(), account);
                customer.getBalance();
                System.out.println("Đã thêm số tài khoản: " + stk + " với số dư là: " + (String.format("%,.0f", Double.parseDouble(balance)) + "đ") + " vào danh sách");
                break;
            } else {
                System.out.println("Số dư không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    private static boolean isIsCheckStk(String stk) {
        boolean isCheckStk = false;
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            Customer cus = bank.getCustomers().get(i);
            for (int j = 0; j < cus.getAccounts().size(); j++) {
                Account acc = cus.getAccounts().get(j);
                if (acc.getAccountNumber().equals(stk)) {
                    isCheckStk = true;
                    break;
                }
            }
        }
        return isCheckStk;
    }

    //chức năng 3
    private static void handleListCustomer() {
        if (!bank.getCustomers().isEmpty()) {
            for (Customer cus : bank.getCustomers()) {
                cus.displayInformation();
            }
        } else {
            System.out.println("Danh sách khách hàng trống!");
        }

    }

    //chức năng 4
    private static void handleCustomerByCCCD(Scanner sc) {
        while (true) {
            System.out.print("Nhập CCCD khách hàng: ");
            String checkCCCD = sc.nextLine();
            if (!bank.isCustomerExisted(checkCCCD)) {
                Customer customer = bank.getCustomerById(checkCCCD);
                customer.displayInformation();
                break;
            } else {
                System.out.println("Số CCCD chưa có trong hệ thống. Vui lòng nhập lại. ");
            }
        }
    }

    //chức năng 5
    private static void handleCustomerByName(Scanner sc) {
        while (true) {
            System.out.print("Nhập tên khách hàng: ");
            String searchName = sc.nextLine();
            boolean found = false;
            for (Customer customer : bank.getCustomers()) {
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
}
