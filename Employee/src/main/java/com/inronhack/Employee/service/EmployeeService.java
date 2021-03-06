package com.inronhack.Employee.service;

import com.inronhack.Employee.exception.EmployeeNotFoundException;
import com.inronhack.Employee.exception.IllegalInputException;
import com.inronhack.Employee.model.Employee;
import com.inronhack.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){ return employeeRepository.findAll(); }
    public Employee findById(Integer id) { return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found")); }
    public Employee create(Employee employee) {
        Optional<Employee> foundEmp = findByUsername(employee.getUsername());
        if (foundEmp.isPresent()) throw new IllegalInputException("Username " + employee.getUsername() + " is already taken");
        return employeeRepository.save(employee);
    }
    public Optional<Employee> findByUsername(String username) {
        Optional<Employee> result = employeeRepository.findByUsername(username);
        return result;
    }
}
