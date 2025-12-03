package com.example.ecom.product.controller;

import com.example.ecom.common.dto.ApiResponse;
import com.example.ecom.product.model.Product;
import com.example.ecom.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {
        return ApiResponse.success(productRepository.findAll());
    }

    @PostMapping
    public ApiResponse<Product> createProduct(@RequestBody Product product) {
        return ApiResponse.success(productRepository.save(product));
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ApiResponse::success)
                .orElse(ApiResponse.error("Product not found"));
    }
}
