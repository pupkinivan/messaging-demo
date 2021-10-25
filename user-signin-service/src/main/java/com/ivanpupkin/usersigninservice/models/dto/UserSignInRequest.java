package com.ivanpupkin.usersigninservice.models.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
public class UserSignInRequest {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String emailAddress;
    @NonNull
    private String phoneNumber;
    @NonNull
    private UserSignInRequest.Address address;

    @Getter
    @Setter
    public static class Address {
        @NonNull
        private String street;
        @NonNull
        private String streetNumber;

        private String apartment;
        @NonNull
        private String city;
        @NonNull
        private String stateOrProvince;
        @NonNull
        private String country;
        @NonNull
        private String zipOrPostalCode;
    }
}
