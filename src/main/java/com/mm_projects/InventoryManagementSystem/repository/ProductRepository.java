package com.mm_projects.InventoryManagementSystem.repository;

import com.mm_projects.InventoryManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
}
