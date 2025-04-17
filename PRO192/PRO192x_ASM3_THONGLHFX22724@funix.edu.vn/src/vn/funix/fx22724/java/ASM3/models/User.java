package vn.funix.fx22724.java.ASM3.models;

public class User {
    private String name;
    private String customerId;

    public User(){}

    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        if(customerId.length() == 12 && customerId.matches("\\d{12}")){
            this.customerId = customerId;
        }else{
            System.out.println("Mã CCCD không hợp lệ! Phải là chuỗi 12 ký tự số.");
        }
    }

}

