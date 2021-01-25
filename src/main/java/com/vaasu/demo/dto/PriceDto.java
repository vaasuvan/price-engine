package com.vaasu.demo.dto;

import com.vaasu.demo.model.Product;

public class PriceDto extends Product {

    private String ultimatePrice;
    private String productName;
    private Long quantity;

    public String getUltimatePrice() {
        return ultimatePrice;
    }

    public void setUltimatePrice(String ultimatePrice) {
        this.ultimatePrice = ultimatePrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
