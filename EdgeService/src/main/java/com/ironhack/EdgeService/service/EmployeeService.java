package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.client.EmployeeClient;
import com.ironhack.EdgeService.exceptions.EmployeeServiceDownException;
import com.ironhack.EdgeService.model.Client.Client;
import com.ironhack.EdgeService.model.Employee.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeClient employeeClient;

    @HystrixCommand(fallbackMethod = "errorFindAll")
    public List<Employee> findAll(){ return employeeClient.findAll(); }

    public List<Employee> errorFindAll() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findAll. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindById")
    public Employee findById(Integer id){ return employeeClient.findById(id); }

    public Employee errorFindById() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreate")
    public Employee create(Employee employee){ return employeeClient.create(employee); }

    public Employee errorCreate() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: create. ");
    }

}
