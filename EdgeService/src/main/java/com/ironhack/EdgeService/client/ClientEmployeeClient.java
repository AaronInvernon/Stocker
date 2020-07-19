package com.ironhack.EdgeService.client;

import com.ironhack.EdgeService.model.Employee.Client;
import com.ironhack.EdgeService.model.Employee.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "employee-service")
public interface ClientEmployeeClient {
    @GetMapping("/employees")
    public List<Employee> findAll();

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable Integer id);

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee);

    @GetMapping("/clients")
    public List<Client> findAllClients();

    @GetMapping("/clients/{id}")
    public Client findClientsById(@PathVariable Integer id);

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client);
}
