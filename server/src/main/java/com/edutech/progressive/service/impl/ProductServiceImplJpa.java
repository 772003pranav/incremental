package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Product;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.repository.ProductRepository;
import com.edutech.progressive.service.ProductService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Day-7 JPA implementation for Product service using associations:
 *  - Product has Warehouse (ManyToOne)
 *  - Use repository methods with nested properties
 */
@Service("productServiceImplJpa")
public class ProductServiceImplJpa implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplJpa(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return new ArrayList<>(productRepository.findAll());
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        // Ensure association object (Warehouse) is set, not just an ID
        if (product.getWarehouse() == null) {
            throw new SQLException("Warehouse association must be set on Product");
        }
        Product saved = productRepository.save(product);
        return saved.getProductId();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        // Same requirement for association
        if (product.getWarehouse() == null) {
            throw new SQLException("Warehouse association must be set on Product");
        }
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        productRepository.deleteById(productId);
    }

    
@Override
public List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException {
    return new ArrayList<>(productRepository.findAllByWarehouse_WarehouseId(warehouseId));
}

}