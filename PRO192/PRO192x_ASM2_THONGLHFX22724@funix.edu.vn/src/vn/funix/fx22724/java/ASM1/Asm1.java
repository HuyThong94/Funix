package vn.funix.fx22724.java.ASM1;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Asm1 {
    private static final String AUTHOR = "FX22724";
    private static final String VERSION = "v1.0.0";
    public static void main(String[] args) {
        getScreen();
    }
    public  static void getScreen(){
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  NGÂN HÀNG SỐ | " + AUTHOR + "@" + VERSION + "           |");
        System.out.println("+----------+--------------------+----------+");
        System.out.println("|  1. Nhập CCCD                            |");
        System.out.println("|  0. Thoát                                |");
        System.out.println("+----------+--------------------+----------+");
        System.out.print("Chọn chức năng: ");
        Scanner sc = new Scanner(System.in);
        int choice = getUserChoice(sc);

        while (true) {
            if (choice == 0) {
                System.out.println("Chương trình kết thúc.");
                break;
            } else if (choice == 1) {
                System.out.print("Choose mode (EASY or HARD): ");
                String mode = sc.nextLine().toUpperCase();

                String securityCode;

                if(mode.equals("EASY") || mode.equals("HARD")){
                    securityCode = generateCode(mode);
                }else{
                    continue;
                }

                System.out.println("Mã xác thực: " + securityCode);
                System.out.print("Nhập mã xác thực: ");
                String useCode = sc.nextLine();
                if(!useCode.equals(securityCode)){
                    System.out.println("Mã xác thực không đúng. Vui lòng thử lại.");
                    continue;
                }
                // Nhập CCCD
                handleCCCDInput(sc);
                break;
            } else {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng nhập lại.");
                System.out.print("Chọn chức năng: ");
            }
        }
    }
    private static void handleCCCDInput(Scanner scanner) {
        while (true) {
            System.out.print("Nhập số CCCD:");
            String cccd = scanner.nextLine().trim();

            if (cccd.equalsIgnoreCase("No")) {
                System.out.println("Thoát chương trình!");
                break;
            }

            if (isValidCCCD(cccd)) {
                // Nếu CCCD hợp lệ, thực hiện các chức năng tiếp theo
                displayMenu(cccd, scanner);
            } else {
                System.out.println("Số CCCD không hơp lệ.\n Vui lòng nhập lại hoặc ‘No’ để thoát:");
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