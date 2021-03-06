package com.ironhack.EdgeService.controller;

import com.ironhack.EdgeService.model.Employee.Employee;
import com.ironhack.EdgeService.model.Employee.LoginDTO;
import com.ironhack.EdgeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Employee login(@AuthenticationPrincipal Employee loginDTO) { return employeeService.login(loginDTO); }

}
