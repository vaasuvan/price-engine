package com.vaasu.demo.service.impl;

import com.vaasu.demo.exception.ProductNotFoundException;
import com.vaasu.demo.model.Product;
import com.vaasu.demo.repository.ProductRepository;
import com.vaasu.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getById(Integer productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("INVALID RECORD ID>>>>" + productId));
    }

    @Override
    public Product createProduct(Product product) {
        logger.info("Creating product......");
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        logger.info("Retrieving all products....");
        return productRepository.findAll();
    }
}
