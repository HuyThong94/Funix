package vn.funix.fx22724.java.asm04.common;

public class CommonValid {

    public static boolean isValidCustomerId(String customerId) {
        return customerId.length() == 12 && customerId.matches("\\d{12}");
    }

    public static boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.length() == 6 && accountNumber.matches("\\d{6}");
    }

    public static boolean isValidMoney(String money) {
        return Double.parseDouble(money) >= 50000 && money.matches("\\d+");
    }

    public static boolean isValidMoneyTranfers(String money) {
        return money.matches("\\d+");
    }

    public static boolean validateAccount(String accountNumber) {
        return accountNumber.length() == 6 && accountNumber.matches("\\d{6}");
    }

}
