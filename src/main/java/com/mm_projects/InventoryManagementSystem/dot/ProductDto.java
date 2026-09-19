package com.mm_projects.InventoryManagementSystem.dot;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    private Long id;

    private Long categoryId;
    private Long productId;
    private Long supplierId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "SKU is required")
    private String sku;

    @Positive(message = "product price must be a positive value")
    private BigDecimal price;

    @Min(value = 0, message = "stock quantity cannot be negative")
    private Integer stockQuantity;

    private String description;

    private LocalDateTime expiryDate;

    private String imageUrl;

    private LocalDateTime createdAt;

    private CategoryDto category;
}
