package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.repository.WarehouseRepository;
import com.edutech.progressive.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("warehouseServiceImplJpa")
public class WarehouseServiceImplJpa implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImplJpa(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException {
        return new ArrayList<>(warehouseRepository.findAll());
    }

    @Override
    public int addWarehouse(Warehouse warehouse) throws SQLException {
        Warehouse saved = warehouseRepository.save(warehouse);
        return saved.getWarehouseId();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException {
        List<Warehouse> list = new ArrayList<>(warehouseRepository.findAll());
        Collections.sort(list); // Warehouse.compareTo: capacity DESC
        return list;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws SQLException {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException {
        warehouseRepository.deleteById(warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return warehouseRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) throws SQLException {
        return new ArrayList<>(warehouseRepository.findAllBySupplier_SupplierId(supplierId));
    }
}