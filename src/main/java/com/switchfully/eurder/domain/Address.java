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

    public Address() {
    }

    private Address(String street, String houseNumber, String city, String postalCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

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


    public static final class Builder {
        private String street;
        private String houseNumber;
        private String city;
        private String postalCode;

        private Builder() {
        }

        public static Builder anAddress() {
            return new Builder();
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build() {
            return new Address(street, houseNumber, city, postalCode);
        }
    }
}
