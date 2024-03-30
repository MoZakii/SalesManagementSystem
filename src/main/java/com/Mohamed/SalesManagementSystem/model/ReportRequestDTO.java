package com.Mohamed.SalesManagementSystem.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReportRequestDTO {

    @NotNull(message = "Start Date is required")
    @DateTimeFormat()
    private LocalDate startDate;

    @NotNull(message = "End Date is required")
    @DateTimeFormat()
    private LocalDate endDate;

    // Getters and setters
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}