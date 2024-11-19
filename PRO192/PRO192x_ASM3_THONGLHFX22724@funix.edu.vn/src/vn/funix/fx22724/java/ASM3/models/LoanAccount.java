package vn.funix.fx22724.java.ASM3.models;

import vn.funix.fx22724.java.ASM2.models.Account;

public class LoanAccount extends Account {
    private static final double MAX_BALANCE = 100000000;
    private static final double FEE_NORMAL = 0.05;
    private static final double FEE_PREMIUM = 0.01;

    public LoanAccount(String accountNumber, double balance, String typeAccount) {
        super(accountNumber, balance, typeAccount);
        if (balance > MAX_BALANCE) {
            throw new IllegalArgumentException("Hạn mức không được vượt quá " + MAX_BALANCE);
        }
    }

    @Override
    public boolean isAccepted(double amount) {
        double fee = isPremium() ? FEE_PREMIUM : FEE_NORMAL;
        double total = amount + (amount * fee);

        if (total > MAX_BALANCE) {
            System.out.println("Hạn mức không được vượt quá " + MAX_BALANCE);
            return false;
        }
        if (getBalance() - total < 0) {
            System.out.println("Số dư không đủ để thực hiện giao dịch");
            return false;
        }
        return true;
    }

    public boolean isPremium() {
        return getBalance() >= 50000000; // Giả định tài khoản Premium từ 50 triệu trở lên.
    }
}

