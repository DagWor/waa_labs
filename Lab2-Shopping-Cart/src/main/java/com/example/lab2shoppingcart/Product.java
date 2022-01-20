package com.example.lab2shoppingcart;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
    @NotNull
    @Size(min = 2, max = 5)
    private String productNo;

    @NotNull
    @Size(min = 2, max = 20)
    private String productName;

    private double price;

    public Product(){}

    public Product(String productNo, String productName, double price) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
    }

    public String getProductNo() {
        return productNo;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
