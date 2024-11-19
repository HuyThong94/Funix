package vn.funix.fx22724.java.ASM3.models;

import vn.funix.fx22724.java.ASM2.models.Account;

public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 50000;
    private static final double MAX_WITHDRAW = 5000000;
    private static final double MIN_WITHDRAW = 50000;

    public SavingsAccount(String accountNumber, double balance, String typeAccount) {
        super(accountNumber, balance, typeAccount);
        if (balance < MIN_BALANCE) {
            throw new IllegalArgumentException("Số dư tối thiểu phải là " + MIN_BALANCE);
        }
    }

    @Override
    public boolean isAccepted(double amount) {
        if (amount < MIN_WITHDRAW || amount > MAX_WITHDRAW) {
            System.out.println("Số tiền rút phải từ " + MIN_WITHDRAW + " đến " + MAX_WITHDRAW);
            return false;
        }
        if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Số dư sau khi rút phải lớn hơn hoặc bằng " + MIN_BALANCE);
            return false;
        }
        return true;
    }
}

