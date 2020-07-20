package com.ironhack.EdgeService.model.Employee;

import com.ironhack.EdgeService.enums.Depart;
import com.ironhack.EdgeService.enums.Role;
import com.ironhack.EdgeService.model.Client.Address;

public class Employee {
    private Integer id;
    private String name;
    private String username;
    private Depart department;
    private String phoneNumber;
    private String password;
    private Role role;

    public Employee(String name, String username, Depart department, String phoneNumber, String password, Role role) {
        this.name = name;
        this.username = username;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Depart getDepartment() {
        return department;
    }

    public void setDepartment(Depart department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
