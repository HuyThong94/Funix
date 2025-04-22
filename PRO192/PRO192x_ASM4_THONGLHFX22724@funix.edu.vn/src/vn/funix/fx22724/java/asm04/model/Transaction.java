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

    public Transaction(String accountNumber, double amount,String time, boolean status, String type) {
        this.id = UUID.randomUUID().toString();
        this.time = time;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = status;
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String toString() {
        return "";
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

}

