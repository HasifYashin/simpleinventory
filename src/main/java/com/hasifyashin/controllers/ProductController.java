package com.hasifyashin.controllers;

import com.hasifyashin.models.Product;
import com.hasifyashin.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
    }
    @GetMapping("/product")
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
