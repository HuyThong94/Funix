package vn.funix.fx22724.java.ASM2.models;

public class User {
    private String name;
    private String customerId;

    public User(){}

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
        try {
            if(customerId.length() == 12 && customerId.matches("\\d{12}"))

            {
                this.customerId = customerId;
            }
        }
        catch(Exception e) {
            System.out.println("Mã CCCD không hợp lệ! Phải là chuỗi 12 ký tự số.");
        }
    }

}

