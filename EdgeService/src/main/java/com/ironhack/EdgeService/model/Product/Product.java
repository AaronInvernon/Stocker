package com.ironhack.EdgeService.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {

    private Integer id;
    private String name;
    private Integer quantity;
    private String maker;
    private String description;
    private BigDecimal price;
    private LocalDate dateAt;

    public Product(String name, Integer quantity, String maker, String description, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.maker = maker;
        this.description = description;
        this.price = price;
        this.dateAt = LocalDate.now();
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDateAt() {
        return dateAt;
    }

    public void setDateAt(LocalDate dateAt) {
        this.dateAt = dateAt;
    }
}
