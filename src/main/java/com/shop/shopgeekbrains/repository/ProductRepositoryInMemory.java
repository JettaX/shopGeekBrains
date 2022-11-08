package com.shop.shopgeekbrains.repository;

import com.shop.shopgeekbrains.dto.ProductDto;
import com.shop.shopgeekbrains.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryInMemory implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public Product insert(Product product) {
        products.add(product);
        return null;
    }

    @Override
    public Product insertFromDto(ProductDto productDto) {
        return insert(Product.builder()
                .id(UUID.randomUUID().toString())
                .title(productDto.getTitle())
                .price(productDto.getPrice())
                .image(productDto.getImage().isEmpty() ? "https://goo.su/OFzBI" : productDto.getImage())
                .build());
    }

    @Override
    public Optional<Product> findById(String productId) {
        return products.stream().filter(product -> product.getId().equals(productId)).findFirst();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
