package com.ironhack.EdgeService.model.Client;


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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
