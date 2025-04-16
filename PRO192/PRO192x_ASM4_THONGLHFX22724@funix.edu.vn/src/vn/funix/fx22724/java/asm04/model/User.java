package vn.funix.fx22724.java.asm04.model;

public class User {
    private String name;
    private String customerId;

    public User(){}

    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }
    public static String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static String getCustomerId() {
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

