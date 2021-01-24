package com.vaasu.demo.service;

import com.vaasu.demo.dto.PriceDto;
import com.vaasu.demo.model.Product;

public interface PriceService {

    PriceDto calculatePrice(Product product, Long quantity);
}
