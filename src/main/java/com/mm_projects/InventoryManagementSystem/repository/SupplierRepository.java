package com.mm_projects.InventoryManagementSystem.repository;

import com.mm_projects.InventoryManagementSystem.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
