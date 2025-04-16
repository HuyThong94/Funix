package vn.funix.fx22724.java.asm04.model;

import java.util.UUID;

public class Bank {
    private String bankId;
    private String bankName;

    public Bank() {
        // Tạo ID ngẫu nhiên cho ngân hàng
        this.bankId = String.valueOf(UUID.randomUUID());
    }

    public String getId() {
        return bankId;
    }
    public void setId(String id) {
        this.bankId = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}


