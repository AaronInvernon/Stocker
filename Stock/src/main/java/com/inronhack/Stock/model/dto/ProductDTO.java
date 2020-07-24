package com.inronhack.Stock.model.dto;

public class ProductDTO {
    private Integer quantity;

    public ProductDTO() {
    }

    public ProductDTO(Integer quantity) {
        setQuantity(quantity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
