package com.edutech.progressive.service;

import com.edutech.progressive.dao.WarehouseDAO;
import com.edutech.progressive.dao.WarehouseDAOImpl;
import com.edutech.progressive.entity.Warehouse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface WarehouseService {

    WarehouseDAO warehouseDAO = new WarehouseDAOImpl();

    List<Warehouse> getAllWarehouses() throws SQLException;

    int addWarehouse(Warehouse warehouse) throws SQLException;

    List<Warehouse> getWarehousesSortedByCapacity() throws SQLException;

    default void emptyArrayList() {
    }

    // Do not implement these methods in WarehouseServiceImplArraylist.java class
    default void updateWarehouse(Warehouse warehouse) throws SQLException {
        warehouseDAO.updateWarehouse(warehouse);
    }

    default void deleteWarehouse(int warehouseId) throws SQLException {
        warehouseDAO.deleteWarehouse(warehouseId);
    }

    default Warehouse getWarehouseById(int warehouseId) throws SQLException {
        return warehouseDAO.getWarehouseById(warehouseId);
    }

    // Do not implement these methods in WarehouseServiceImplArraylist.java and WarehouseServiceImplJdbc.java class
    default List<Warehouse> getWarehouseBySupplier(int supplierId) throws SQLException {
        List<Warehouse> warehouses = warehouseDAO.getAllWarehouse();
        List<Warehouse> filtered = new ArrayList<>();

        for (Warehouse warehouse : warehouses) {
            if (warehouse.getSupplierId() == supplierId) {
                filtered.add(warehouse);
            }
        }
        return filtered;
    }
}