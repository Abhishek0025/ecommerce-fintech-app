package com.ecommerce.backend.controller;

import java.util.List;
import java.util.UUID;

import com.ecommerce.backend.dto.CategoryResponse;
import com.ecommerce.backend.dto.ProductResponse;
import com.ecommerce.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")


public class ProductController {
    private final ProductService productService;

    // GET /api/products
    // GET /api/products?category=electronics

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts(@RequestParam(required = false) String category) {
        return ResponseEntity.ok(productService.getAllProducts(category));
    }

    // GET /api/products/{id}
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // GET /api/categories
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(productService.getAllCategories());
    }
}
