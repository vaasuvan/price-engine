package com.vaasu.demo.dto;

import com.vaasu.demo.model.Product;

public class PriceDto extends Product {

    private Double ultimatePrice;
    private String productName;
    private Long quantity;

    public Double getUltimatePrice() {
        return ultimatePrice;
    }

    public void setUltimatePrice(Double ultimatePrice) {
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
