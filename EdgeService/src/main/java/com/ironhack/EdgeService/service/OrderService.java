package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.client.OrderClient;
import com.ironhack.EdgeService.exceptions.OrderServiceDownException;
import com.ironhack.EdgeService.model.Order.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderClient orderClient;

    @HystrixCommand(fallbackMethod = "errorFindAll")
    public List<Order> findAll(){ return orderClient.findAll(); }

    public List<Order> errorFindAll() {
        throw new OrderServiceDownException("Order Service Down Exception. Method: findAll. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindById")
    public Order findById(Integer id){ return orderClient.findById(id); }

    public Order errorFindById(Integer id) {
        throw new OrderServiceDownException("Order Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreate")
    public Order create(Order order){ return orderClient.create(order); }

    public Order errorCreate(Order order) {
        throw new OrderServiceDownException("Order Service Down Exception. Method: create. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindByEmployeeId")
    public List<Order> findByEmployeeId(Integer id){ return orderClient.findByEmployeeId(id); }

    public List<Order> errorFindByEmployeeId(Integer id) {
        throw new OrderServiceDownException("Order Service Down Exception. Method: findByEmployeeId.");
    }

    @HystrixCommand(fallbackMethod = "errorFindByClientId")
    public List<Order> findByClientId(Integer id){ return orderClient.findByClientId(id); }

    public List<Order> errorFindByClientId(Integer id) {
        throw new OrderServiceDownException("Order Service Down Exception. Method: findByClientId.");
    }
}
