package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.Address;

public class CreateCustomerDto {

    private final String firstname;
    private final String lastname;
    private final String email;
    private final CreateAddressDto createAddressDto;
    private final String phonenumber;

    private CreateCustomerDto(String firstname, String lastname, String email, CreateAddressDto address, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.createAddressDto = address;
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public CreateAddressDto getCreateAddressDto() {
        return createAddressDto;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public static final class Builder {
        private String firstname;
        private String lastname;
        private String email;
        private CreateAddressDto createAddressDto;
        private String phonenumber;

        private Builder() {
        }

        public static Builder aCreateCustomerDto() {
            return new Builder();
        }

        public Builder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAddress(CreateAddressDto createAddressDto) {
            this.createAddressDto = createAddressDto;
            return this;
        }

        public Builder withPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public CreateCustomerDto build() {
            return new CreateCustomerDto(firstname, lastname, email, createAddressDto, phonenumber);
        }
    }




/*
    public static class Builder {
        private String firstname;
        private String lastname;
        private String email;
        private Address address;
        private String phonenumber;

        public static Builder builder() {
            return new Builder();
        }

        public CreateCustomerDto build() {
            return new CreateCustomerDto(firstname, lastname, email, address, phonenumber);
        }

        public Builder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }
    }
    */

}
