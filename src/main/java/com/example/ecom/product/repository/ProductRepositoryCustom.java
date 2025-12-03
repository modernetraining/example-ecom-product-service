package com.example.ecom.product.repository;

import com.example.ecom.product.model.Product;
import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findProductsByName(String name);
}
