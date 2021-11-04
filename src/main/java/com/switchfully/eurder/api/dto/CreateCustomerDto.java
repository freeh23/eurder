package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.Address;

public class CreateCustomerDto {

    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phonenumber;

    public CreateCustomerDto(String firstname, String lastname, String email, Address address, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    /*
    public CreateCustomerDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CreateCustomerDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CreateCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateCustomerDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public CreateCustomerDto setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }
    */

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }



    public static class CreateCustomerDtoBuilder {
        private String firstname;
        private String lastname;
        private String email;
        private Address address;
        private String phonenumber;

        public static CreateCustomerDtoBuilder createCustomerDtoBuilder() {
            return new CreateCustomerDtoBuilder();
        }

        public CreateCustomerDto build() {
            return new CreateCustomerDto(firstname, lastname, email, address, phonenumber);
        }

        public CreateCustomerDtoBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public CreateCustomerDtoBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public CreateCustomerDtoBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CreateCustomerDtoBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public CreateCustomerDtoBuilder withPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }
    }
}
