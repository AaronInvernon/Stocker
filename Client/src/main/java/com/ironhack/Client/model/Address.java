package com.ironhack.Client.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private String city;
    private Integer postCode;
    private String street;

    public Address() {
    }

    public Address(String country, String city, Integer postCode, String street) {
        this.country = country;
        this.city = city;
        this.postCode = postCode;
        this.street = street;
    }
}