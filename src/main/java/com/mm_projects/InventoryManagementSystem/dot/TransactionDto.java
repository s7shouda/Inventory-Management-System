package com.mm_projects.InventoryManagementSystem.dot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mm_projects.InventoryManagementSystem.enums.TransactionStatus;
import com.mm_projects.InventoryManagementSystem.enums.TransactionType;
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
public class TransactionDto {

    private Long id;

    private Integer totalProducts;

    private BigDecimal totalPrice;

    private TransactionType transactionType;

    private TransactionStatus status;

    private String description;

    private String note;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    private ProductDto product;

    private UserDto user;

    private SupplierDto supplier;
}
