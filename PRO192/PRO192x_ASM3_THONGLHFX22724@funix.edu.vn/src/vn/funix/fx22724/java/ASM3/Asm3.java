package vn.funix.fx22724.java.ASM3;

import vn.funix.fx22724.java.ASM2.models.Account;
import vn.funix.fx22724.java.ASM2.models.Bank;
import vn.funix.fx22724.java.ASM2.models.Customer;

import java.util.Scanner;

public class Asm3 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v2.0.0";
    private static final Bank bank  = new Bank();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getScreen(sc);
    }
    public static void menuScreen(){
        System.out.println(" 1. Thông tin tài khoản");
        System.out.println(" 2. Thêm tài khoản ATM");
        System.out.println(" 3. Thêm tài khoản tín dụng");
        System.out.println(" 4. Rút tiền");
        System.out.println(" 5. Lịch sử giao dịch");
        System.out.println(" 0. Thoát");
        System.out.println("+----------+--------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }
    public  static void getScreen(Scanner sc) {
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
                handleCCCDInput(sc, customer);
                getScreen(sc);
            } else if(choice == 2) {
                handleAccount(sc, customer);
                getScreen(sc);
            } else if(choice == 3) {
                handleListCustomer();
                getScreen(sc);
            } else if(choice == 4) {
                handleCustomerByCCCD(sc);
                getScreen(sc);
            } else if(choice == 5) {
                handleCustomerByName(sc);
                getScreen(sc);
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                getScreen(sc);
            }
        }
    }

    //Chức năng 1
    private static void handleCCCDInput(Scanner scanner, Customer customer) {
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
                boolean ischeckCustomer = false;
                for(Customer cus : bank.getCustomers()){
                    if (cus.getCustomerId().equals(cccd)) {
                        ischeckCustomer = true;
                        break;
                    }
                }
                if(!ischeckCustomer){
                    customer.setCustomerId(cccd);
                    System.out.println("Đã thêm khách hàng " + customer.getCustomerId() + " vào danh sách");
                    bank.addCustomer(customer);
                    break;
                }else{
                    System.out.println("Số CCCD đã có trong hệ thống. Vui lòng nhập lại hoặc 'No' để thoát:");
                }
            } else {
                System.out.println("Số CCCD không hơp lệ. Vui lòng nhập lại hoặc ‘No’ để thoát:");
            }
        }
    }

    //chức năng 2
    private static void handleAccount(Scanner sc, Customer customer) {
        while(true){
            System.out.print("Nhập CCCD khách hàng: ");
            String checkCCCD = sc.nextLine();
            boolean ischeckCustomer = false;
            for(Customer cus : bank.getCustomers()){
                if (cus.getCustomerId().equals(checkCCCD)) {
                    ischeckCustomer = true;
                    customer = cus;
                    break;
                }
            }
            if(ischeckCustomer){
                handleAccountNumber(sc, customer);
                break;
            }else{
                System.out.println("Số CCCD chưa có trong hệ thống. Vui lòng nhập lại. ");
            }
        }
    }

    private static void handleAccountNumber(Scanner sc, Customer customer) {
        Account account = new Account();
        while(true){
            System.out.print("Nhập mã số tài khoản gồm 6 chữ số: ");
            String stk = sc.nextLine().trim();
            if(isValidSTK(stk)){
                boolean ischeckStk = false;
                for(int i = 0; i < bank.getCustomers().size(); i++){
                    Customer cus =  bank.getCustomers().get(i);
                    for(int j = 0; j < cus.getAccounts().size(); j++){
                        Account acc = cus.getAccounts().get(j);
                        if (acc.getAccountNumber().equals(stk)) {
                            ischeckStk = true;
                            break;
                        }
                    }

                }
                if(!ischeckStk){
                    account.setAccountNumber(stk);
                    System.out.print("Nhập số dư: ");
                    double balance = getBalance(sc);
                    account.setBalance(balance);
                    customer.addAccount(account);
                    customer.getBalance();
                    System.out.println("Đã thêm số tài khoản: " + stk + " với số dư là: " + (String.format("%,.0f", balance) + "đ") + " vào danh sách");
                    break;
                }else{
                    System.out.println("Số tài khoản đã có trong hệ thống. Vui lòng nhập lại: ");
                }
            }else{
                System.out.println("Số tài khoản không hơp lệ. Vui lòng nhập lại. ");
            }
        }
    }

    //chức năng 3
    private static void handleListCustomer() {
        if(!bank.getCustomers().isEmpty()){
            for(Customer cus : bank.getCustomers()){
                cus.displayInformation();
            }
        }else{
            System.out.println("Danh sách khách hàng trống!");
        }

    }

    //chức năng 4
    private static void handleCustomerByCCCD(Scanner sc) {
        while(true){
            Customer customer = new Customer();
            System.out.print("Nhập CCCD khách hàng: ");
            String checkCCCD = sc.nextLine();
            boolean ischeckCustomer = false;
            for(Customer cus : bank.getCustomers()){
                if (cus.getCustomerId().equals(checkCCCD)) {
                    ischeckCustomer = true;
                    customer.displayInformation();
                    break;
                }
            }
            if(ischeckCustomer){
                break;
            }else{
                System.out.println("Số CCCD chưa có trong hệ thống. Vui lòng nhập lại. ");
                break;
            }
        }
    }

    //chức năng 5
    private static void handleCustomerByName(Scanner sc) {
        while(true){
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
            }else{
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
