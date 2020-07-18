package com.inronhack.Employee.controller;

import com.inronhack.Employee.model.Client;
import com.inronhack.Employee.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> findAll(){ return clientService.findAll(); }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findById(@PathVariable Integer id){ return clientService.findById(id); }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client employee) { return clientService.create(employee); }
}
