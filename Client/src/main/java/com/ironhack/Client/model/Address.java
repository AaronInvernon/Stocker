package com.ironhack.Client.model;

import javax.persistence.*;

@Embeddable
public class Address {
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