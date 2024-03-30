package com.Mohamed.SalesManagementSystem.model;

import com.Mohamed.SalesManagementSystem.LoggingAndAuditing.AuditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Client extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Mobile number is required")
    private String mobile;

    @NotNull(message = "Email is required")
    @Email(message = "Email must have valid format")
    private String email;

    @NotNull(message = "Address is required")
    private String address;

    public Client() {

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client(Long id, String name, String lastName, String mobile, String email, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }
}
