package com.edutech.progressive.repository;

import com.edutech.progressive.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Supplier findBySupplierId(int supplierId);
    void deleteBySupplierId(int supplierId);
}