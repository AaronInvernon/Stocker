package com.ironhack.EdgeService.controller;

import com.ironhack.EdgeService.model.Order.Order;
import com.ironhack.EdgeService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order){ return orderService.create(order); }

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> findAll(){ return orderService.findAll(); }

    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order findById(@PathVariable Integer id){ return orderService.findById(id); }

    @GetMapping("/orders/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> findByClientId(@PathVariable(name = "id") Integer clientId){ return orderService.findByClientId(clientId); }

    @GetMapping("/orders/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> findByEmployeeId(@PathVariable(name = "id") Integer employeeId){ return orderService.findByEmployeeId(employeeId); }

}
