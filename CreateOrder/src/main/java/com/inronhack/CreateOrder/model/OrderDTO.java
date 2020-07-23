package com.inronhack.CreateOrder.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private List<Integer> products;

    public OrderDTO(List<Integer> products) {
        this.products = new ArrayList<>();
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }
}
