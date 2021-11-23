package com.switchfully.eurder.api.dto;

import javax.persistence.Column;

public class CreateAddressDto {

    private final String street;
    private final String houseNumber;
    private final String city;
    private final String postalCode;

    private CreateAddressDto(String street, String houseNumber, String city, String postalCode) {
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

        public static Builder aCreateAddressDto() {
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

        public CreateAddressDto build() {
            return new CreateAddressDto(street, houseNumber, city, postalCode);
        }
    }
}
