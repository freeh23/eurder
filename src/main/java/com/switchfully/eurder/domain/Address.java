package com.switchfully.eurder.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name ="street")
    private String street;
    @Column(name ="housenumber")
    private String houseNumber;
    @Column(name ="city")
    private String city;
    @Column(name ="postalcode")
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
