package com.vaasu.demo.controller;

import com.vaasu.demo.dto.PriceDto;
import com.vaasu.demo.exception.ProductNotFoundException;
import com.vaasu.demo.model.Product;
import com.vaasu.demo.service.PriceService;
import com.vaasu.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class PriceController {

    private static Logger logger = LoggerFactory.getLogger(PriceController.class);

    private static Long INITIAL_FIFTY = 50L;
    private PriceService priceService;

    private ProductService productService;

    public PriceController(PriceService priceService, ProductService productService) {
        this.priceService = priceService;
        this.productService = productService;
    }

    @GetMapping(value = "/price/{productId}/{quantity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PriceDto calculatePrice(@PathVariable Integer productId, @PathVariable Long quantity) {
        Product product = productService.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Invalid product id : " + productId);
        }
        logger.info("Calculating product is >>>{}", product);
        return priceService.calculatePrice(product, quantity);
    }

    @GetMapping(value = "/price/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceDto> calculatePriceOfFifty(@PathVariable Integer productId) {
        Product product = productService.getById(productId);
        if (product == null) {
            throw new ProductNotFoundException("Invalid product id : " + productId);
        }
        logger.info("Calculating 1-50 units of products prices is >>>{}", product);
        return priceService.calculatePriceOfFifty(product, INITIAL_FIFTY);
    }
}
