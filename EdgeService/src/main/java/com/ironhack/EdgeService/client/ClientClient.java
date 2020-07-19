package com.ironhack.EdgeService.client;

import com.ironhack.EdgeService.model.Client.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "client-service")
public interface ClientClient {

    @GetMapping("/clients")
    public List<Client> findAllClients();

    @GetMapping("/clients/{id}")
    public Client findClientsById(@PathVariable Integer id);

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client);
}
