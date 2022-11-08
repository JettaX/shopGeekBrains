package com.shop.shopgeekbrains.controller;

import com.shop.shopgeekbrains.model.Product;
import com.shop.shopgeekbrains.dto.ProductDto;
import com.shop.shopgeekbrains.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/getProductById/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        ProductDto product = new ProductDto();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/addProduct")
    public String saveProduct(@ModelAttribute ProductDto productDto) {
        System.out.println(productDto.getImage());
        productRepository.insertFromDto(productDto);
        return "redirect:/";
    }

}
