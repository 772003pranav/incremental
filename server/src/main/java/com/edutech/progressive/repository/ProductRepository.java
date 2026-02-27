package com.edutech.progressive.repository;

import com.edutech.progressive.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByProductId(int productId);

    // Day-7: association-aware query (Product.warehouse.warehouseId)
    List<Product> findAllByWarehouse_WarehouseId(int warehouseId);
}