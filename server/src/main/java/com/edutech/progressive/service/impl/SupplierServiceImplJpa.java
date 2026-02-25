package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SupplierServiceImplJpa implements SupplierService {

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException {
        return List.of();   // JPA logic will come later
    }

    @Override
    public int addSupplier(Supplier supplier) throws SQLException {
        return -1;
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        return List.of();
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException {}

    @Override
    public void deleteSupplier(int supplierId) throws SQLException {}

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException {
        return null;
    }
}