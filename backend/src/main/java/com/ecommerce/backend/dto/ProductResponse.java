package com.ecommerce.backend.dto;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder  // Lombok: lets you do ProductResponse.builder().name("x").price(10).build()
public class ProductResponse {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String imageUrl;
    private String categoryName;  // flattened — no nested Category object
    private Boolean active;
    private LocalDateTime createdAt;
}