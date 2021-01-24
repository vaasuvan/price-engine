package com.vaasu.demo.service;

import com.vaasu.demo.model.Product;

import java.util.List;

public interface ProductService {

    Product getById(Integer productId);

    List<Product> findAllProducts();

    Product createProduct(Product product);
}
