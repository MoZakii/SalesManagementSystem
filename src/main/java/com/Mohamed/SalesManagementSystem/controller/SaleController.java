package com.Mohamed.SalesManagementSystem.controller;

import com.Mohamed.SalesManagementSystem.model.Sale;
import com.Mohamed.SalesManagementSystem.service.SaleService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@Validated
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getSales(){
        return saleService.getAllSales();
    }

    @PostMapping
    public ResponseEntity<Sale> addSale(@Valid @RequestBody Sale sale){
        Sale addedSale = saleService.createSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedSale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@Valid @RequestBody Sale sale, @PathVariable Long id){
        saleService.updateSale(id, sale);
        Sale updatedSale = saleService.updateSale(id, sale);
        if (updatedSale != null) {
            return ResponseEntity.ok(updatedSale);
        } else {
            throw new EntityNotFoundException();
        }
    }

}
