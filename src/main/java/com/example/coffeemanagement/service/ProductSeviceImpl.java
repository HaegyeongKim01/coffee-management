package com.example.coffeemanagement.service;

import com.example.coffeemanagement.model.Category;
import com.example.coffeemanagement.model.Product;
import com.example.coffeemanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductSeviceImpl implements ProductService{

    private final ProductRepository repository;

    public ProductSeviceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product createProduct(String productName, Category category, long price) {
        var insertProduct = new Product(UUID.randomUUID(), productName, category, price);
        return repository.insert(insertProduct);
    }

    @Override
    public Product createProduct(String productName, Category category, long price, String description) {
        var insertProduct = new Product(UUID.randomUUID(), productName, category, price, description, LocalDateTime.now(), LocalDateTime.now());
        return repository.insert(insertProduct);
    }
}
