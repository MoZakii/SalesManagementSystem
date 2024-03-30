package com.Mohamed.SalesManagementSystem.controller;

import com.Mohamed.SalesManagementSystem.model.ReportRequestDTO;
import com.Mohamed.SalesManagementSystem.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@Validated
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/sales")
    public ResponseEntity<Map<String, Object>> generateSalesReport(@Valid @RequestBody ReportRequestDTO requestDTO) {
        LocalDate startDate = requestDTO.getStartDate();
        LocalDate endDate = requestDTO.getEndDate();

        Map<String, Object> salesReport = reportService.generateSalesReport(startDate, endDate);
        return ResponseEntity.ok(salesReport);
    }


    @GetMapping("/clients")
    public ResponseEntity<Map<String, Object>> generateClientReport() {
        Map<String, Object> clientReport = reportService.generateClientReport();
        return ResponseEntity.ok(clientReport);
    }

    @GetMapping("/products")
    public ResponseEntity<Map<String, Object>> generateProductReport() {
        Map<String, Object> productReport = reportService.generateProductReport();
        return ResponseEntity.ok(productReport);
    }
}
