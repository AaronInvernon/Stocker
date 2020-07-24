package com.inronhack.CreateBill.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inronhack.CreateBill.model.Bill;
import com.inronhack.CreateBill.repository.BillRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BillControllerTest {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Bill bill;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        bill = new Bill(1, 2, new BigDecimal("100"));
        Bill bill2 = new Bill(1, 1, new BigDecimal("110"));
        billRepository.saveAll(Stream.of(bill, bill2).collect(Collectors.toList()));
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/bills")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/bills/" + bill.getId()))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void findByClientId() throws Exception {
        mockMvc.perform(get("/bills/client/" + bill.getClientId()))
                .andExpect(status().isOk()).andReturn();
    }
}