package com.example.coffeemanagement.controller;

import com.example.coffeemanagement.dto.CreateProductRequest;
import com.example.coffeemanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 관리자가 web page에 접속하기 위해 View를 반환하는 Controller
 */
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     *
     * @param model Spring MVC에서 전달 역할을 하는 interface
     * @return 전체 Product 반환
     */
    @GetMapping("/products")
    public String productsPage(Model model) {
        var products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("new-product")
    public String newProductPage() {
        return "new-product";
    }

    @PostMapping("/products")
    public String newProduct(CreateProductRequest createProductRequest) {
        productService.createProduct(createProductRequest.productName(),
                createProductRequest.category(),
                createProductRequest.price(),
                createProductRequest.descripton());
        return "redirect:/products";
    }
}
