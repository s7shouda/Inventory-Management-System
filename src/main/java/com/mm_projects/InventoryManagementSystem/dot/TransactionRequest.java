package com.mm_projects.InventoryManagementSystem.dot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mm_projects.InventoryManagementSystem.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequest {

    @NotBlank(message = "Product id is required")
    private Long productId;

    @NotBlank(message = "Quantity id is required")
    private Integer quantity;

    private Integer supplierId;

    private String description;

    private String note;
}
