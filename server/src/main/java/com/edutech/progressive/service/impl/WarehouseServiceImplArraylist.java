package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.entity.Warehouse;
import com.edutech.progressive.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList implementation used for Day-2/5 tasks.
 * Updated for Day-7 associations:
 *  - Warehouse now has Supplier (ManyToOne).
 *  - Use warehouse.getSupplier().getSupplierId() instead of warehouse.getSupplierId().
 */
@Service("warehouseServiceImplArraylist")
public class WarehouseServiceImplArraylist implements WarehouseService {

    private static final List<Warehouse> w = new ArrayList<>();

    @Override
    public List<Warehouse> getAllWarehouses() {
        return new ArrayList<>(w);
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        w.add(warehouse);
        return w.size();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        List<Warehouse> copy = new ArrayList<>(w);
        // Assumes Warehouse implements Comparable by capacity (DESC) per Day-7
        Collections.sort(copy);
        return copy;
    }

    @Override
    public void emptyArrayList() {
        w.clear();
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        // Simple in-memory update: replace by id if exists
        for (int i = 0; i < w.size(); i++) {
            if (w.get(i).getWarehouseId() == warehouse.getWarehouseId()) {
                w.set(i, warehouse);
                return;
            }
        }
    }

    @Override
    public void deleteWarehouse(int warehouseId) {
        w.removeIf(wh -> wh.getWarehouseId() == warehouseId);
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) {
        for (Warehouse wh : w) {
            if (wh.getWarehouseId() == warehouseId) {
                return wh;
            }
        }
        return null;
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {
        List<Warehouse> filtered = new ArrayList<>();
        for (Warehouse wh : w) {
            if (wh.getSupplier() != null
                    && wh.getSupplier().getSupplierId() == supplierId) {
                filtered.add(wh);
            }
        }
        return filtered;
    }
}