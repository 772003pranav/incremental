package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.SupplierService;

public class SupplierServiceImplArraylist implements SupplierService {

    List<Supplier> s = new ArrayList<>();

    @Override
    public List<Supplier> getAllSuppliers() {
        return s;
    }

    @Override
    public int addSupplier(Supplier supplier) {
        s.add(supplier);
        return s.size();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        Collections.sort(s);
        return s;
    }
}