package com.inronhack.Stock.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inronhack.Stock.exception.ProductNotFoundException;
import com.inronhack.Stock.model.Product;
import com.inronhack.Stock.repository.ProductRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Product product;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        product = new Product( "Chair", 150,"LERU", "A simple chair", new BigDecimal("10"));
        Product product2 = new Product("Table", 100,"LERU", "A simple table", new BigDecimal("15"));

        productRepository.saveAll(Stream.of(product, product2).collect(Collectors.toList()));
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        MvcResult result = mockMvc.perform(get("/products/" + product.getId()))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("chair"));
    }


    @Test
    void create() throws Exception {
        Product product = new Product("lamp", 55, "IKEA", "LED lamp", new BigDecimal("15"));
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product))
        ).andExpect(status().isCreated());
    }

    @Test
    void delete() {
        //mockMvc.perform(delete("/products")).andExpect(status().isNoContent());
    }

    @Test
    void decrementQuantity() {
    }
}