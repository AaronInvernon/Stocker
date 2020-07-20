package com.inronhack.CreateOrder.service;

import com.inronhack.CreateOrder.exception.OrderNotFoundException;
import com.inronhack.CreateOrder.model.Order;
import com.inronhack.CreateOrder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){ return orderRepository.findAll(); }
    public Order findById(Integer id) { return orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException("Order not found")); }
    public Order create(Order order) {
        order.setCreateAt(LocalDate.now());
        System.out.println(order.getCreateAt());
        return orderRepository.save(order);
    }
    public List<Order> findByClientId(Integer clientId) { return orderRepository.findByClientId(clientId); }
    public List<Order> findByEmployeeId(Integer employeeId) { return orderRepository.findByEmployeeId(employeeId); }
}
