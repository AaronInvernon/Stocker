package com.ironhack.EdgeService.model.Client;

public class Address {
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
