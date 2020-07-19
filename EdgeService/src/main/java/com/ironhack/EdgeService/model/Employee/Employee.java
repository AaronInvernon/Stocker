package com.ironhack.EdgeService.model.Employee;

import com.ironhack.EdgeService.enums.Depart;

public class Employee {
    private Integer id;
    private String name;
    private Depart department;
    private String phoneNumber;
    private Address address;

    public Employee(String name, Depart department, String phoneNumber, Address address) {
        this.name = name;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
