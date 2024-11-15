package vn.funix.fx22724.java.ASM2;

import vn.funix.fx22724.java.ASM2.models.Account;
import vn.funix.fx22724.java.ASM2.models.Bank;
import vn.funix.fx22724.java.ASM2.models.Customer;
import vn.funix.fx22724.java.ASM2.models.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Asm2 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v2.0.0";
    private static Bank bank  = new Bank();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getScreen(sc);
    }
    public static void menuScreen(){
        System.out.println(" 1. Thêm khách hàng");
        System.out.println(" 2. Thêm tài khoản cho khách hàng");
        System.out.println(" 3. Hiển thị danh sách khách hàng");
        System.out.println(" 4. Tìm theo CCCD");
        System.out.println(" 5. Tìm theo tên khách hàng");
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
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Chọn chức năng: ");
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
                System.out.println("Số CCCD không hơp lệ.\n Vui lòng nhập lại hoặc ‘No’ để thoát:");
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
                System.out.println("Số CCCD chưa có trong hệ thống. Vui lòng nhập lại: ");
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
                for(Account acc : customer.getAccounts()){
                    if(acc.getAccountNumber().equals(stk)){
                        ischeckStk = true;
                    }
                }
                if(!ischeckStk){
                    account.setAccountNumber(stk);
                    System.out.print("Nhập số dư: ");
                    double balance = getBalance(sc);
                    account.setBalance(balance);
                    customer.addAccount(account);
                    customer.getBalance();
                    System.out.println("Đã thêm số tài khoản: " + stk + " với số dư là: " + String.format("%,.0f", balance) + " vào danh sách");
                    System.out.println("1. Quay về menu.");
                    System.out.println("2. Trở lại.");
                    System.out.println("0. Thoát.");
                    break;
                }else{
                    System.out.println("Số tài khoản đã có trong hệ thống. Vui lòng nhập lại: ");
                }
            }else{
                System.out.println("Số tài khoản không hơp lệ.\n Vui lòng nhập lại: ");
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

    private static void displayMenu(String cccd, Scanner scanner) {
        while (true) {
            System.out.println("| 1. Kiểm tra nơi sinh");
            System.out.println("| 2. Kiểm tra năm sinh, giới tính");
            System.out.println("| 3. Kiểm tra số ngẫu nhiên");
            System.out.println("| 0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Nơi sinh: " + getProvince(cccd.substring(0, 3)));
                    break;
                case 2:
                    System.out.println("Giới tính: " + getGender(cccd.charAt(3)) + " | Năm sinh: " + getYearOfBirth(cccd));
                    break;
                case 3:
                    System.out.println("Số ngẫu nhiên: " + cccd.substring(6));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        }
    }

    private static String getProvince(String code) {
        switch (code) {
            case "001": return "Ha Noi";
            case "002": return "Ha Giang";
            case "004": return "Cao Bang";
            case "006": return "Bac Kan";
            case "008": return "Tuyen Quang";
            case "010": return "Lao Cai";
            case "011": return "Dien Bien";
            case "012": return "Lai Chau";
            case "014": return "Son La";
            case "015": return "Yen Bai";
            case "017": return "Hoa Binh";
            case "019": return "Thai Nguyen";
            case "020": return "Lang Son";
            case "022": return "Quang Ninh";
            case "024": return "Bac Giang";
            case "025": return "Phu Tho";
            case "026": return "Vinh Phuc";
            case "027": return "Bac Ninh";
            case "030": return "Hai Duong";
            case "031": return "Hai Phong";
            case "033": return "Hung Yen";
            case "034": return "Thai Binh";
            case "035": return "Ha Nam";
            case "036": return "Nam Dinh";
            case "037": return "Ninh Binh";
            case "038": return "Thanh Hoa";
            case "040": return "Nghe An";
            case "042": return "Ha Tinh";
            case "044": return "Quang Binh";
            case "045": return "Quang Tri";
            case "046": return "Thua Thien Hue";
            case "048": return "Da Nang";
            case "049": return "Quang Nam";
            case "051": return "Quang Ngai";
            case "052": return "Binh Dinh";
            case "054": return "Phu Yen";
            case "056": return "Khanh Hoa";
            case "058": return "Ninh Thuan";
            case "060": return "Binh Thuan";
            case "062": return "Kon Tum";
            case "064": return "Gia Lai";
            case "066": return "Dak Lak";
            case "067": return "Dak Nong";
            case "068": return "Lam Dong";
            case "070": return "Binh Phuoc";
            case "072": return "Tay Ninh";
            case "074": return "Binh Duong";
            case "075": return "Dong Nai";
            case "077": return "Ba Ria - Vung Tau";
            case "079": return "Ho Chi Minh";
            case "080": return "Long An";
            case "082": return "Tien Giang";
            case "083": return "Ben Tre";
            case "084": return "Tra Vinh";
            case "086": return "Vinh Long";
            case "087": return "Dong Thap";
            case "089": return "An Giang";
            case "091": return "Kien Giang";
            case "092": return "Can Tho";
            case "093": return "Hau Giang";
            case "094": return "Soc Trang";
            case "095": return "Bac Lieu";
            case "096": return "Ca Mau";
            default: return "Khong xac dinh";
        }
    }

    private static String getGender(char genderCode) {
        String gender;
        switch (genderCode) {
            case '0':
            case '2':
            case '4':
            case '6':
            case '8':
                gender = "Nam"; break;
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
                gender = "Nữ"; break;

            default : gender = "Không xác định";
        }
        return gender;
    }

    private static int getYearOfBirth(String cccd) {
        int centuryCode = Character.getNumericValue(cccd.charAt(3));
        int year = Integer.parseInt(cccd.substring(4, 6));
        int century = (centuryCode / 2) * 100 + 1900;
        return century + year;
    }

    private static boolean isValidCCCD(String cccd) {
        return cccd.length() == 12 && cccd.matches("\\d{12}");
    }

    private static boolean isValidSTK(String cccd) {
        return cccd.length() == 6 && cccd.matches("\\d{6}");
    }
    // Hàm tạo mã bảo mật với chỉ số (EASY) hoặc số và chữ (HARD)
    public static String generateCode(String mode) {
        Random random = new Random();

        if (mode.equalsIgnoreCase("EASY")) {
            // Tạo mã gồm 3 ký tự số
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                code.append(random.nextInt(10)); // Chỉ thêm số từ 0-9
            }
            return code.toString();

        } else if (mode.equalsIgnoreCase("HARD")) {
            // Tạo mã gồm 6 ký tự số và chữ
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(characters.length());
                code.append(characters.charAt(index)); // Thêm ký tự ngẫu nhiên
            }
            return code.toString();
        } else {
            return "Invalid mode selected.";
        }
    }
}
