package com.Mohamed.SalesManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is required")
    @DateTimeFormat()
    private LocalDate creationDate;

    @NotNull(message = "Client name is required")
    private String client;

    @NotNull(message = "Seller name is required")
    private String seller;

    @NotNull(message = "Product name is required")
    private String product;

    @NotNull(message = "Total is required")
    @PositiveOrZero(message = "Total must be non-negative")
    private Integer total;

    public Sale(Long id, LocalDate creationDate, String client, String seller, Integer total, String product) {
        this.id = id;
        this.creationDate = creationDate;
        this.client = client;
        this.seller = seller;
        this.total = total;
        this.product = product;
    }

    public Sale() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
