package com.example.coffeemanagement.dto;

import com.example.coffeemanagement.model.Category;

public record CreateProductRequest(
        String productName,
        Category category,
        long price,
        String descripton
        ) {
}
