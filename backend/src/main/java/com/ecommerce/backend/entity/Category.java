package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor

public class Category {
    @Id
    /*
        Unique row identifier
                +
        Database generates it
                +
        Primary key
     */

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String slug;
}
