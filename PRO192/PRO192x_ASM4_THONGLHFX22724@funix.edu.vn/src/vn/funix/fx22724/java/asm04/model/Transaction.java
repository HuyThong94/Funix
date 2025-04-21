package vn.funix.fx22724.java.asm04.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String accountNumber;
    private double amount;
    private String time;
    private boolean status;
    private String type;

    public Transaction() {
        this.id = UUID.randomUUID().toString();
        this.time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }

    public Transaction(String accountNumber, double amount, boolean status) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = status;
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


    public String toString() {
        return "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

