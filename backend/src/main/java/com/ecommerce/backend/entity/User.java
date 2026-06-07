package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false ,unique = true)
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String passwordHash;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "wallet_balance", precision = 10, scale = 2)
    private BigDecimal walletBalance = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;

    public enum Role { CUSTOMER, ADMIN }

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


}
