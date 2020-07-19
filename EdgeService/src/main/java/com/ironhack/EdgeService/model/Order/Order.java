package com.ironhack.EdgeService.model.Order;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Integer id;
    private Integer employeeId;
    private Integer clientId;
    private List<Integer> products;
    private LocalDate createAt;

    public Order() {
    }

    public Order(Integer employeeId, Integer clientId, List<Integer> products) {
        this.employeeId = employeeId;
        this.clientId = clientId;
        this.products = products;
        this.createAt = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
