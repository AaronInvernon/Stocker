package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.client.ClientEmployeeClient;
import com.ironhack.EdgeService.exceptions.EmployeeServiceDownException;
import com.ironhack.EdgeService.model.Employee.Client;
import com.ironhack.EdgeService.model.Employee.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private ClientEmployeeClient clientEmployeeClient;

    @HystrixCommand(fallbackMethod = "errorFindAll")
    public List<Employee> findAll(){ return clientEmployeeClient.findAll(); }

    public List<Employee> errorFindAll() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findAll. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindById")
    public Employee findById(Integer id){ return clientEmployeeClient.findById(id); }

    public Employee errorFindById() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreate")
    public Employee create(Employee employee){ return clientEmployeeClient.create(employee); }

    public Employee errorCreate() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: create. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindAllClients")
    public List<Client> findAllClients(){ return clientEmployeeClient.findAllClients(); }

    public List<Client> errorFindAllClients() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findAllClients. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindClientsById")
    public Client findClientsById(Integer id){ return clientEmployeeClient.findClientsById(id); }

    public Employee errorFindClientsById() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreateClient")
    public Client createClient(Client client){ return clientEmployeeClient.createClient(client); }

    public Client errorCreateClient() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: CreateClient. ");
    }

}
