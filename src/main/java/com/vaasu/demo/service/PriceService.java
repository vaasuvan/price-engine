package com.vaasu.demo.service;

import com.vaasu.demo.dto.PriceDto;
import com.vaasu.demo.model.Product;

import java.util.List;

public interface PriceService {

    PriceDto calculatePrice(Product product, Long quantity);

    List<PriceDto> calculatePriceOfFifty(Product product, Long quantity);
}
