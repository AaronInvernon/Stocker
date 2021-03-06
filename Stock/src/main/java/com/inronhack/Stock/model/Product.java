package com.inronhack.Stock.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    @Id
    private String id;
    private String name;
    private Integer quantity;
    private String maker;
    private String description;
    private BigDecimal price;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateAt;

    public Product(String name, Integer quantity, String maker, String description, BigDecimal price) {
        setName(name);
        setQuantity(quantity);
        setMaker(maker);
        setDescription(description);
        setPrice(price);
        this.dateAt = LocalDate.now();
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
