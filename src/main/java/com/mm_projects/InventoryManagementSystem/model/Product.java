package com.mm_projects.InventoryManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String sku;

    private BigDecimal price;

    private Integer stockQuantity;

    private String description;

    private LocalDateTime expiryDate;

    private String imageUrl;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                ", expiryDate=" + expiryDate +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}
