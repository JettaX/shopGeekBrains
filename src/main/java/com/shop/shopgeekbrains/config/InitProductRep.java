package com.shop.shopgeekbrains.config;

import com.shop.shopgeekbrains.Util.RandomProduct;
import com.shop.shopgeekbrains.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitProductRep {

    @Autowired
    private void initProduct(ProductRepository productRepository) {
        RandomProduct.getRandomProducts(50).forEach(productRepository::insert);
    }

}
