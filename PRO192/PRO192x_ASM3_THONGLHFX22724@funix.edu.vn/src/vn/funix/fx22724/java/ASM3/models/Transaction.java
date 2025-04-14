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
        this.time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }

    public String getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

