package com.ironhack.EdgeService.service;

import com.ironhack.EdgeService.client.EmployeeClient;
import com.ironhack.EdgeService.exceptions.EmployeeServiceDownException;
import com.ironhack.EdgeService.model.Employee.Employee;
import com.ironhack.EdgeService.security.CustomSecurityUser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService {
    @Autowired
    private EmployeeClient employeeClient;

    @HystrixCommand(fallbackMethod = "errorFindAll")
    public List<Employee> findAll(){ return employeeClient.findAll(); }

    public List<Employee> errorFindAll() {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findAll. ");
    }

    @HystrixCommand(fallbackMethod = "errorFindById")
    public Employee findById(Integer id){ return employeeClient.findById(id); }

    public Employee errorFindById(Integer id) {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: findById. ");
    }

    @HystrixCommand(fallbackMethod = "errorCreate")
    public Employee create(Employee employee){ return employeeClient.create(employee); }

    public Employee errorCreate(Employee employee) {
        throw new EmployeeServiceDownException("Employee Service Down Exception. Method: create. ");
    }

    @Override
    @HystrixCommand(fallbackMethod = "errorLoadUserByUsername")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> user = employeeClient.findByUsername(username);
        System.out.println("Usuario buscado");
        return new CustomSecurityUser(user.orElseThrow(() ->
                new UsernameNotFoundException("Invalid username/password combination.")));
    }

    public UserDetails errorLoadUserByUsername(String username){
        throw new EmployeeServiceDownException("SalesRep Service Down. Method loadUserByUsername. ");
    }
}
