package net.cuongmai.onlineshop.model;

import java.io.Serializable;

public class SignUpModel implements Serializable{
    private User user;
    private Address billingAddress;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
