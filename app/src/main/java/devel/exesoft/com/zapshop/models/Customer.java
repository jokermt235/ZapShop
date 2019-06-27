package devel.exesoft.com.zapshop.models;

import java.util.Date;

import io.realm.RealmObject;

public class Customer extends RealmObject {
    private String name;
    private String device_id;
    private String email;
    private String address;
    private String phone;
    private String cart_token;
    private Date created_at = new Date();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setCart_token(String cart_token) {
        this.cart_token = cart_token;
    }

    public String getCart_token() {
        return cart_token;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
