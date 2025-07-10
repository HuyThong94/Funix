package lap15.lap15_3;

import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String address;
    private final String email;
    private final String phone;
    private final String postcode;
    private final String country;
    private final Date createdDate;
    public Company(String name, String address, String email, String phone, String postcode, String country) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.postcode = postcode;
        this.country = country;
        this.createdDate = new Date();
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
