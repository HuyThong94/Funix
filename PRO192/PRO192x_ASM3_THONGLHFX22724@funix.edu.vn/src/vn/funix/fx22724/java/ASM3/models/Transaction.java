package vn.funix.fx22724.java.ASM3.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private String id;
    private String accountNumber;
    private double amount;
    private String time;
    private boolean status;

    public Transaction(String accountNumber, double amount, boolean status) {
        this.id = UUID.randomUUID().toString();
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = status;
        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public String toString() {
        return "Mã giao dịch: " + id +
                ", Số tài khoản: " + accountNumber +
                ", Số tiền: " + amount +
                ", Thời gian: " + time +
                ", Trạng thái: " + (status ? "Thành công" : "Thất bại");
    }
}
