package com.ironhack.EdgeService.controller;

import com.ironhack.EdgeService.model.Client.Client;
import com.ironhack.EdgeService.service.ClientService;
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
    public List<Client> findAllClient(){ return clientService.findAllClients(); }

    @GetMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findClientsById(@PathVariable Integer id){ return clientService.findClientsById(id); }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) { return clientService.createClient(client); }
}
