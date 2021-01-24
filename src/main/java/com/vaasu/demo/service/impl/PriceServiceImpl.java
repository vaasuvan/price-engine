package com.vaasu.demo.service.impl;

import com.vaasu.demo.dto.PriceDto;
import com.vaasu.demo.model.Product;
import com.vaasu.demo.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        PriceDto priceDto = new PriceDto();
        priceDto.setProductName(product.getProductName());
        priceDto.setUltimatePrice(String.valueOf(ultimatePrice));
        logger.info("Calculated price >>>{}", ultimatePrice);
        return priceDto;
    }

}
