package com.switchfully.eurder.domain;

public class Address {
    private String street;
    private String houseNumber;
    private String city;
    private String postalCode;


    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Address setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
