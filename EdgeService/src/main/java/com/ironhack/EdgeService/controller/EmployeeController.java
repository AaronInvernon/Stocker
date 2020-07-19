package com.ironhack.EdgeService.controller;

import com.ironhack.EdgeService.client.ClientEmployeeClient;
import com.ironhack.EdgeService.model.Employee.Client;
import com.ironhack.EdgeService.model.Employee.Employee;
import com.ironhack.EdgeService.model.Product.Product;
import com.ironhack.EdgeService.model.Product.ProductDTO;
import com.ironhack.EdgeService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private ClientEmployeeClient clientEmployeeClient;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll(){ return clientEmployeeClient.findAll(); }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findById(@PathVariable Integer id){ return clientEmployeeClient.findById(id); }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) { return clientEmployeeClient.create(employee); }

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> findAllClient(){ return clientEmployeeClient.findAllClients(); }

    @GetMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findClientsById(@PathVariable Integer id){ return clientEmployeeClient.findClientsById(id); }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) { return clientEmployeeClient.createClient(client); }
}
