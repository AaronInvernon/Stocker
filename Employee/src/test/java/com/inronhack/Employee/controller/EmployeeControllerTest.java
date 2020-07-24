package com.inronhack.Employee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inronhack.Employee.enums.Depart;
import com.inronhack.Employee.enums.Role;
import com.inronhack.Employee.model.Employee;
import com.inronhack.Employee.repository.EmployeeRepository;
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
class EmployeeControllerTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Employee employee;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        employee = new Employee( "Aaron", "aaron", Depart.SALES, "9876584321", "aaron", Role.ROLE_SALES);
        Employee employee2 = new Employee("Manu", "manu", Depart.SALES, "9876584321", "manu", Role.ROLE_SALES);

        employeeRepository.saveAll(Stream.of(employee, employee2).collect(Collectors.toList()));
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/employees")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        MvcResult result = mockMvc.perform(get("/employees/" + employee.getId()))
                .andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("aaron"));
    }

}