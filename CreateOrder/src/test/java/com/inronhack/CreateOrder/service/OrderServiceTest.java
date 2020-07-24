package com.inronhack.CreateOrder.service;

import com.inronhack.CreateOrder.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;


    @Test
    void create() {
        Order product = new Order(1,2);
        orderService.create(product);
        assertEquals(1, product.getEmployeeId());
    }

  /*  @Test
    void addProduct() {
        Order order1 = new Order(1, 1);
        order1.setId(10);
        orderService.create(order1);
        orderService.addProduct(10,1);
        assertEquals(1, order1.getProducts().size());
    }*/
}