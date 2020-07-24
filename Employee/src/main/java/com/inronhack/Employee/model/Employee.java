package com.inronhack.Employee.model;

import com.inronhack.Employee.enums.Depart;
import com.inronhack.Employee.enums.Role;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String username;
    @Enumerated(EnumType.STRING)
    private Depart department;
    private String phoneNumber;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Employee(String name, String username, Depart department, String phoneNumber, String password, Role role) {
        setName(name);
        setUsername(username);
        setDepartment(department);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setRole(role);
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", department=" + department +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
