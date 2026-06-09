package com.ecommerce.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    private String token;
    private String email;
    private String fullName;
    private String role;
    private String message;
}