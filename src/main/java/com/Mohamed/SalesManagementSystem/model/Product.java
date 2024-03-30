package com.Mohamed.SalesManagementSystem.model;

import com.Mohamed.SalesManagementSystem.LoggingAndAuditing.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Product extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;


    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Category is required")
    private String category;

    @NotNull(message = "Date is required")
    @DateTimeFormat()
    private LocalDate creationDate;

    @NotNull(message = "Available quantity is required")
    @PositiveOrZero(message = "Available quantity must be non-negative")
    private int availableQuantity;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be non-negative")
    private double price;

    public Product(Long id, String name, String description, String category, LocalDate creationDate, Integer availableQuantity, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.creationDate = creationDate;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
