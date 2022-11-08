package com.shop.shopgeekbrains.repository;

import com.shop.shopgeekbrains.dto.ProductDto;
import com.shop.shopgeekbrains.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product insert(Product product);

    Product insertFromDto(ProductDto productDto);

    Optional<Product> findById(String productId);

    List<Product> findAll();
}
