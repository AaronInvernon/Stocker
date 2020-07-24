package com.inronhack.CreateOrder.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer employeeId;
    private Integer clientId;
    @ElementCollection
    private List<Integer> products;
    private LocalDate createAt;

    public Order() {
    }

    public Order(Integer employeeId, Integer clientId) {
        setEmployeeId(employeeId);
        setClientId(clientId);
        this.products = new ArrayList<>();
        this.createAt = LocalDate.now();
    }

    public Integer getId() {
        return id;
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

    public void setCreateAt(LocalDate ld) {
        this.createAt = ld;
    }
}
