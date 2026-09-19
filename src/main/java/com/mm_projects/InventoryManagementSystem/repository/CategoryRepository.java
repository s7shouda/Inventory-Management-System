package com.mm_projects.InventoryManagementSystem.repository;

import com.mm_projects.InventoryManagementSystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
