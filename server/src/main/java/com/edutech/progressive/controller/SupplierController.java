package com.edutech.progressive.controller;
 
import com.edutech.progressive.entity.Supplier;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;

@RestController

@RequestMapping

public class SupplierController {
 
    public ResponseEntity<List<Supplier>> getAllSuppliers() {

        return null;

    }
 
    public ResponseEntity<Supplier> getSupplierById(int supplierId) {

        return null;

    }
 
    public ResponseEntity<Integer> addSupplier(Supplier supplier) {

        return null;

    }
 
    public ResponseEntity<Void> updateSupplier(Supplier supplier) {

        return null;

    }
 
    public ResponseEntity<Void> deleteSupplier(int supplierId) {

        return null;

    }
 
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {

        return null;

    }
 
    public ResponseEntity<Integer> addSupplierToArrayList(Supplier supplier) {

        return null;

    }
 
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {

        return null;

    }

}
 