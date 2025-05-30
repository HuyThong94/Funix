package vn.funix.fx22724.java.ASM3.models;

import vn.funix.fx22724.java.ASM3.service.ResportService;
import vn.funix.fx22724.java.ASM3.Withdraw;


public class SavingsAccount extends Account implements Withdraw, ResportService {
    private static final double MAX_WITHDRAW = 5000000;
    private static final double MIN_WITHDRAW = 50000;

    public SavingsAccount(String accountNumber, double balance, String typeAccount) {
        super(accountNumber, balance, typeAccount);
    }

    @Override
    public boolean withdraw(double amount) {
        boolean isWithdrawn = false;
        if (isAccepted(amount)) {
            setBalance(getBalance() - amount);
//            getTransactions().add(new Transaction(getAccountNumber(), amount, true));
            isWithdrawn = true;
            System.out.println("Rút tiền thành công!");
            logTransaction(amount, true);
            log(amount);
        } else {
            System.out.println("Rút tiền thất bại!");
        }
        return isWithdrawn;
    }

    @Override
    public boolean isAccepted(double amount) {
        if (amount % 10000 != 0) {
            System.out.println("Số tiền rút phải là bội số của 10.000đ");
            return false;
        }
        if (Customer.isCustomerPremium()) {
            if (amount < MIN_WITHDRAW) {
                System.out.println("Số tiền rút tối thiểu là  " + MIN_WITHDRAW + "đ");
                return false;
            }
        } else {
            if (amount < MIN_WITHDRAW || amount > MAX_WITHDRAW) {
                System.out.println("Số tiền rút phải từ " + MIN_WITHDRAW + " đến " + MAX_WITHDRAW);
                return false;
            }
        }
        if (amount >= getBalance()) {
            System.out.println("Số dư trong tài khoản không đủ.");
            return false;
        }
        return true;
    }

    @Override
    public void log(double amount) {
        double balance = getBalance();
        System.out.println("+----------+--------------------+----------+");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DICH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", String.format("%,.0f", amount) + "đ");
        System.out.printf("SO DU: %31s%n", String.format("%,.0f", balance) + "đ");
        System.out.printf("PHI + VAT: %27s%n", String.format("%,.0f", 0.0f) + "đ");
        System.out.println("+----------+--------------------+----------+");
    }
}
