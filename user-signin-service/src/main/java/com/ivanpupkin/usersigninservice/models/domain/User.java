package com.ivanpupkin.usersigninservice.models.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ivanpupkin.usersigninservice.models.dto.UserSignInRequest;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id",
        scope = User.class
)
@Document(collection = "userSignIn")
public class User implements Serializable {
    private String firstName;
    private String lastName;
    @MongoId
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private User.Address address;

    @Getter
    @Setter
    public static class Address implements Serializable {
        private String street;
        private String streetNumber;
        private String apartment;
        private String city;
        private String stateOrProvince;
        private String country;
        private String zipOrPostalCode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("User: {\n\t");
        stringBuilder.append("firstName: ");
        stringBuilder.append(firstName);
        stringBuilder.append("\n\t");
        stringBuilder.append("lastName: ");
        stringBuilder.append(lastName);
        stringBuilder.append("\n\t");
        stringBuilder.append("username: ");
        stringBuilder.append(username);
        stringBuilder.append("\n\t");
        stringBuilder.append("password: ");
        stringBuilder.append(password);
        stringBuilder.append("\n\t");
        stringBuilder.append("emailAddress: ");
        stringBuilder.append(emailAddress);
        stringBuilder.append("\n\t");
        stringBuilder.append("phoneNumber: ");
        stringBuilder.append(phoneNumber);
        stringBuilder.append("\n\taddress: {\n\t\t");
        stringBuilder.append("street: ");
        stringBuilder.append(address.getStreet());
        stringBuilder.append("\n\t\t");
        stringBuilder.append("streetNumber: ");
        stringBuilder.append(address.getStreetNumber());
        stringBuilder.append("\n\t\t");
        stringBuilder.append("apartment: ");
        stringBuilder.append(address.getApartment());
        stringBuilder.append("\n\t\t");
        stringBuilder.append("city: ");
        stringBuilder.append(address.getCity());
        stringBuilder.append("\n\t\t");
        stringBuilder.append("stateOrProvince: ");
        stringBuilder.append(address.getStateOrProvince());
        stringBuilder.append("\n\t\t");
        stringBuilder.append("country: ");
        stringBuilder.append(address.getCountry());
        stringBuilder.append("\n\t\t");
        stringBuilder.append("zipOrPostalCode: ");
        stringBuilder.append(address.getZipOrPostalCode());
        stringBuilder.append("\n\t}\n}");
        return stringBuilder.toString();
    }
}
