package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "wallet_transactions")
@Data
@NoArgsConstructor
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum TransactionType {
        TOP_UP,    // user added money to wallet
        PURCHASE,  // wallet used to pay for order
        REFUND     // money returned to wallet
    }
}