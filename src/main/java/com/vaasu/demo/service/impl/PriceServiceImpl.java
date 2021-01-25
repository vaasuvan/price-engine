package com.vaasu.demo.service.impl;

import com.vaasu.demo.dto.PriceDto;
import com.vaasu.demo.model.Product;
import com.vaasu.demo.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private static Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);

    @Override
    public PriceDto calculatePrice(Product product, Long quantity) {
        logger.info("Calculating product is >>>{}, AND Quantity is {}", product.getProductName(), quantity);
        double ultimatePrice = 0;
        Double unitPrice = (product.getCartonPrice() / product.getNumberOfUnitInCarton()) * 1.3;
        if (quantity >= product.getNumberOfUnitInCarton()) {
            //Get the number of unit having no any discount
            Long numberOfUnitWithoutConcession = quantity % product.getNumberOfUnitInCarton();
            // get the number of cartons
            Long numberOfCartons = quantity / product.getNumberOfUnitInCarton();
            // if purchase carton more than 3 get 10% discount
            if (numberOfCartons >= 3) {
                ultimatePrice = (numberOfCartons * product.getCartonPrice() * 0.9) + (numberOfUnitWithoutConcession * unitPrice);
            } else {
                ultimatePrice = (numberOfCartons * product.getCartonPrice()) + (numberOfUnitWithoutConcession * unitPrice);
            }
        } else {
            //calculate without carton and discount price
            ultimatePrice = quantity * unitPrice;
        }
        DecimalFormat df2 = new DecimalFormat("#.##");
        df2.setRoundingMode(RoundingMode.UP);
        PriceDto priceDto = new PriceDto();
        priceDto.setProductName(product.getProductName());
        priceDto.setUltimatePrice(String.valueOf(df2.format(ultimatePrice)));
        logger.info("Calculated price >>>{}", ultimatePrice);
        return priceDto;
    }

    @Override
    public List<PriceDto> calculatePriceOfFifty(Product product, Long quantity) {
        List<PriceDto> priceDtos = new ArrayList<>();
        for (long i = 1; i < quantity + 1; i++) {
            PriceDto priceDto = calculatePrice(product, i);
            priceDto.setQuantity(i);
            priceDtos.add(priceDto);
            priceDto.setCartonPrice(product.getCartonPrice());
            priceDto.setProductName(product.getProductName());
            priceDto.setNumberOfUnitInCarton(product.getNumberOfUnitInCarton());
        }
        return priceDtos;
    }
}
