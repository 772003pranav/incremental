package com.edutech.progressive.service.impl;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SupplierServiceImplArraylist implements SupplierService {

    private final List<Supplier> supplierList = new ArrayList<>();

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierList;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        supplierList.add(supplier);
        return supplierList.size();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        List<Supplier> sorted = new ArrayList<>(supplierList);
        Collections.sort(sorted);
        return sorted;
    }

    @Override
    public void emptyArrayList() {
        supplierList.clear();
    }
}