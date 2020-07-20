package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.client.ClientClient;
import com.ironhack.EdgeService.exceptions.EmployeeServiceDownException;
import com.ironhack.EdgeService.model.Client.Client;
import com.ironhack.EdgeService.model.Employee.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientClient clientClient;

    @HystrixCommand(fallbackMethod = "errorFindAllClients")
    public List<Client> findAllClients(){ return clientClient.findAllClients(); }

    public List<Client> errorFindAllClients() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findAllClients. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindClientsById")
    public Client findClientsById(Integer id){ return clientClient.findClientsById(id); }

    public Employee errorFindClientsById(Integer id) {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreateClient")
    public Client createClient(Client client){ return clientClient.createClient(client); }

    public Client errorCreateClient(Client client) {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: CreateClient. ");
    }
}
