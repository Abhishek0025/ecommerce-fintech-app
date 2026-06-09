package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.ProductResponse;
import com.ecommerce.backend.dto.CategoryResponse;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.repository.ProductRepository;
import com.ecommerce.backend.repository.CategoryRepository;
import com.ecommerce.backend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    // Dependencies that the service class need: ProductRepo and CategoryRepo
    private final ProductRepository productRepository; // ProductService needs ProductRepository to get data from DB.
    private final CategoryRepository categoryRepository;

    // Method that the controller need: productService.getAllProducts()
    public List<ProductResponse> getAllProducts() {
        return productRepository.findByActiveTrue()
                .stream()
                .map(this::toProductResponse)
                .toList();
    }

    // Get all products, or filter by category slug if provided
    public List<ProductResponse> getAllProducts(String categorySlug) {
        List<Product> products;

        if(categorySlug != null && !categorySlug.isEmpty()) {
            // find category by slug first and then filter products
            var category = categoryRepository.findBySlug(categorySlug)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Category not found: " + categorySlug));

            products = productRepository.findByCategoryIdAndActiveTrue(category.getId());
        } else {
            products = productRepository.findByActiveTrue();
        }

        return products.stream()
                .map(this::toProductResponse)
                .toList();
    }

    // Get single product by Id
    public ProductResponse getProductById(UUID id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product not found with id: " + id));
        return toProductResponse(product);
    }

    // Get all the categories
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> CategoryResponse.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .slug(c.getSlug())
                        .build())
                .toList();
    }

    private ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .imageUrl(product.getImageUrl())
                .active(product.getActive())
                .createdAt(product.getCreatedAt())
                .build();
    }

}
