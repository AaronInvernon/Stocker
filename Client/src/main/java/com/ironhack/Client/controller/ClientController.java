package com.ironhack.Client.controller;

import com.ironhack.Client.model.Client;
import com.ironhack.Client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> findAll(){ return clientService.findAll(); }

    @GetMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findById(@PathVariable Integer id){ return clientService.findById(id); }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) { return clientService.create(client); }
}
