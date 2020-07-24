package com.ironhack.Client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.Client.model.Address;
import com.ironhack.Client.model.Client;
import com.ironhack.Client.repository.ClientRepository;
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
class ClientControllerTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Client client;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        Address ad = new Address();
        client = new Client( "Aaron", "987654321", ad);
        Client client2 = new Client( "Manu", "654987321", ad);

        clientRepository.saveAll(Stream.of(client, client2).collect(Collectors.toList()));
    }

    @AfterEach
    void tearDown() {
        clientRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/clients")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        MvcResult result = mockMvc.perform(get("/clients/" + client.getId()))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Aaron"));
    }


    @Test
    void createClient() throws Exception {
        Address ad = new Address();
        Client product = new Client( "Aaron", "987654321", ad);
        mockMvc.perform(post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product))
        ).andExpect(status().isCreated());
    }
}