package com.inronhack.Employee.controller;

import com.inronhack.Employee.model.Employee;
import com.inronhack.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll(){ return employeeService.findAll(); }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findById(@PathVariable Integer id){ return employeeService.findById(id); }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) { return employeeService.create(employee); }

    @GetMapping( "/users/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> findByUsername(@PathVariable(name = "username") String username) {
        return employeeService.findByUsername(username);
    }
}
