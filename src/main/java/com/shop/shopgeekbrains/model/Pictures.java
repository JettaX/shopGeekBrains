package com.shop.shopgeekbrains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pictures {
    String id;
    String author;
    int width;
    int height;
    String url;
    String download_url;
}
