package com.inronhack.CreateOrder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inronhack.CreateOrder.model.Order;
import com.inronhack.CreateOrder.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class OrderControllerTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Order order;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        order = new Order( 1,2);
        Order order2 = new Order(1,1);

        orderRepository.saveAll(Stream.of(order, order2).collect(Collectors.toList()));
    }

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/orders")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        MvcResult result = mockMvc.perform(get("/orders/" + order.getId()))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void findByClientId() throws Exception {
        MvcResult result = mockMvc.perform(get("/orders/client/" + order.getClientId()))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void findByEmployeeId() throws Exception {
        MvcResult result = mockMvc.perform(get("/orders/employee/" + order.getEmployeeId()))
                .andExpect(status().isOk()).andReturn();
    }
}