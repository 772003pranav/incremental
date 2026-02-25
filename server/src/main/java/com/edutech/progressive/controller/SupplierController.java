package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.service.impl.SupplierServiceImplArraylist;
import com.edutech.progressive.service.impl.SupplierServiceImplJpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierServiceImplJpa supplierServiceJpa;
    private final SupplierServiceImplArraylist supplierArray;

    public SupplierController(SupplierServiceImplJpa supplierServiceJpa,
                              SupplierServiceImplArraylist supplierArray) {
        this.supplierServiceJpa = supplierServiceJpa;
        this.supplierArray = supplierArray;
    }

    // ================= JPA =================

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() throws SQLException {
        return ResponseEntity.ok(supplierServiceJpa.getAllSuppliers());
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId)
            throws SQLException {
        return ResponseEntity.ok(supplierServiceJpa.getSupplierById(supplierId));
    }

    @PostMapping
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier)
            throws SQLException {
        int id = supplierServiceJpa.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier(@PathVariable int supplierId,
                                               @RequestBody Supplier supplier)
            throws SQLException {
        supplier.setSupplierId(supplierId);
        supplierServiceJpa.updateSupplier(supplier);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId)
            throws SQLException {
        supplierServiceJpa.deleteSupplier(supplierId);
        return ResponseEntity.noContent().build();
    }

    // ================= ARRAYLIST =================

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        return ResponseEntity.ok(supplierArray.getAllSuppliers());
    }

    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        return ResponseEntity.ok(supplierArray.getAllSuppliersSortedByName());
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(
            @RequestBody Supplier supplier) {
        int size = supplierArray.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(size);
    }
}