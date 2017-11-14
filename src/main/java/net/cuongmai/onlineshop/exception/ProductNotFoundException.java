package net.cuongmai.onlineshop.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{

    private String message;

    public ProductNotFoundException() {
        this("The product you have requested is not available!");
    }

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
