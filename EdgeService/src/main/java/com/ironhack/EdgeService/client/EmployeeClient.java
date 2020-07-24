package com.ironhack.EdgeService.client;

import com.ironhack.EdgeService.model.Client.Client;
import com.ironhack.EdgeService.model.Employee.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
    @GetMapping("/employees")
    public List<Employee> findAll();

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable Integer id);

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee);

    @GetMapping( "/users/{username}")
    public Optional<Employee> findByUsername(@PathVariable(name = "username") String username);

}
