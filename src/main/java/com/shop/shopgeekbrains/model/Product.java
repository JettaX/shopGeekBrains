package com.shop.shopgeekbrains.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product{
    private String id;
    private String title;
    private int price;
    private String image;

    public Product(String title, int price, String image) {
        id = UUID.randomUUID().toString();
        this.title = title;
        this.price = price;
        this.image = image;
    }
}
