package com.ironhack.EdgeService.client;

import com.ironhack.EdgeService.model.Order.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderClient {

    @PostMapping("/orders")
    public Order create(@RequestBody Order order);

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> findAll();

    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable Integer id);

    @GetMapping("/orders/client/{id}")
    public List<Order> findByClientId(@PathVariable(name = "id") Integer clientId);

    @GetMapping("/orders/employee/{id}")
    public List<Order> findByEmployeeId(@PathVariable(name = "id") Integer employeeId);
}
