package vn.funix.fx22724.java.ASM3.models;

import vn.funix.fx22724.java.ASM2.models.Account;
import vn.funix.fx22724.java.ASM2.models.Customer;
import vn.funix.fx22724.java.ASM3.service.ResportService;
import vn.funix.fx22724.java.ASM3.Withdraw;


public class LoanAccount extends Account implements Withdraw, ResportService {
    private static final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;
    protected static final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    protected static final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
    private static final double MIN_WITHDRAW = 50000;

    public LoanAccount(String accountNumber, double balance, String typeAccount) {
        super(accountNumber, balance, typeAccount);
    }

    public static double getFee(boolean isPremium) {
        return isPremium ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE;
    }

    @Override
    public boolean withdraw(double amount) {
        boolean isWithdrawn = false;
        double fee = getFee(Customer.isCustomerPremium());
        if (isAccepted(amount)) {
            double withdrawAmount = amount + amount * fee;
            setBalance(getBalance() - withdrawAmount);
            getTransactions().add(new Transaction(getAccountNumber(), amount, true));
            isWithdrawn = true;
            System.out.println("Rút tiền thành công!");
            log(amount);
        } else {
            System.out.println("Rút tiền thất bại!");
        }

        return isWithdrawn;
    }

    @Override
    public boolean isAccepted(double amount) {
        double fee = Customer.isCustomerPremium() ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE;
        if (amount % 10000 != 0) {
            System.out.println("Số tiền rút phải là bội số của 10.000đ");
            return false;
        }
        if (amount < MIN_WITHDRAW || amount > LOAN_ACCOUNT_MAX_BALANCE) {
            System.out.println("Số tiền rút phải từ " + MIN_WITHDRAW + " đến " + LOAN_ACCOUNT_MAX_BALANCE);
            return false;
        }
        double minWithdraw = getBalance() + amount * fee;
        if (amount >= minWithdraw) {
            System.out.println("Số dư trong tài khoản không đủ.");
            return false;
        }
        return true;
    }

    @Override
    public void log(double amount) {
        double fee = isAccountPremium() ? LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE : LOAN_ACCOUNT_WITHDRAW_FEE;
        System.out.println("+----------+--------------------+----------+");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DICH LOAN");
        System.out.printf("NGAY G/D: %28s%n", getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", String.format("%,.0f", amount) + "đ");
        System.out.printf("SO DU: %31s%n", String.format("%,.0f", getBalance()) + "đ");
        System.out.printf("PHI + VAT: %27s%n", String.format("%,.0f", (amount * fee)) + "đ");
        System.out.println("+----------+--------------------+----------+");
    }
}

