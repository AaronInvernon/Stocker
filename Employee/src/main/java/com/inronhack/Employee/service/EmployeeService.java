package com.inronhack.Employee.service;

import com.inronhack.Employee.exception.EmployeeNotFoundException;
import com.inronhack.Employee.model.Employee;
import com.inronhack.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){ return employeeRepository.findAll(); }
    public Employee findById(Integer id) { return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found")); }
    public Employee create(Employee employee) { return employeeRepository.save(employee); }
}
