package com.shop.shopgeekbrains.Util;

import com.shop.shopgeekbrains.model.Pictures;
import com.shop.shopgeekbrains.model.Product;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class RandomProduct {

    public static List<Product> getRandomProducts(int size) {
        Pictures[] pictures = getPictures(size);
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            products.add(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .title(RandomStringUtils.random(5))
                    .price(new Random().nextInt(1000))
                    .image(pictures[i].getDownload_url())
                    .build());
        }
        return products;
    }

    private static Pictures[] getPictures(int size) {
        String url = "https://picsum.photos/v2/list?page=2&limit=" + size;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Pictures[]> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Pictures[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Pictures[].class);
        return response.getBody();
    }
}
