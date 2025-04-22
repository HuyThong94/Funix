package vn.funix.fx22724.java.asm04.model;

//import

import vn.funix.fx22724.java.asm04.dao.AccountDao;
import vn.funix.fx22724.java.asm04.dao.TransactionDao;
import vn.funix.fx22724.java.asm04.service.ITransfer;
import vn.funix.fx22724.java.asm04.service.Withdraw;
import vn.funix.fx22724.java.asm04.service.IReport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SavingsAccount extends Account implements Withdraw, IReport, ITransfer {
    private static final double MAX_WITHDRAW = 5000000;
    private static final double MIN_WITHDRAW = 50000;

    public SavingsAccount() {
        super();
    }

    @Override
    public boolean withdraw(double amount) {
        Account account = new Account();
        boolean isWithdraw = false;
        if (isAccepted(amount)) {
            setBalance(getBalance() - amount);
            AccountDao.update(this);
            String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
            createTransaction(0-amount, date, true, "WITHDRAW");
            isWithdraw = true;
            System.out.println("Rút tiền thành công!");
            log(amount, "WITHDRAW", account);
        } else {
            System.out.println("Rút tiền thất bại!");
        }
        return isWithdraw;
    }

    @Override
    public boolean transfers(double amount, Account reveiveAccount) {
        boolean isTransfers = false;
        if (isAccepted(amount)) {
            setBalance(getBalance() - amount);
            reveiveAccount.setBalance(reveiveAccount.getBalance() + amount);
            AccountDao.update(reveiveAccount);
            AccountDao.update(this);
            String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
            createTransaction(0-amount, date, true, "TRANSFER");
            reveiveAccount.createTransaction(amount, date, true, "TRANSFER");
            isTransfers = true;
            System.out.println("Chuyển tiền thành công, biên lai gia dịch");
            log(amount, "TRANSFERS", reveiveAccount);
        } else {
            System.out.println("Chuyển tiền thất bại!");
        }
        return isTransfers;
    }

    @Override
    public boolean isAccepted(double amount) {
        if (amount % 10000 != 0) {
            System.out.println("Số tiền rút phải là bội số của 10.000đ");
            return false;
        }
        if (isAccountPremium()) {
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
    public boolean isAccountPremium() {
        return this.getBalance() >= 10000000;
    }

    @Override
    public void log(double amount, String type, Account receiveAccount) {
        double balance = getBalance();
        System.out.println("+----------+--------------------+----------+");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DICH SAVINGS");
        System.out.printf("NGAY G/D: %28s%n", getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        if (type.equals("WITHDRAW")) {
            System.out.printf("SO TIEN RUT: %25s%n", String.format("%,.2f", amount) + "đ");
        } else if (type.equals("DEPOSIT")) {
            System.out.printf("SO TIEN: %29s%n", String.format("%,.2f", amount) + "đ");
        } else {
            System.out.printf("SO TIEN CHUYEN: %22s%n", String.format("%,.2f", amount) + "đ");
        }
        System.out.printf("SO DU: %31s%n", String.format("%,.2f", balance) + "đ");
        System.out.printf("PHI + VAT: %27s%n", String.format("%,.2f", 0.0f) + "đ");
        System.out.println("+----------+--------------------+----------+");
    }
}
