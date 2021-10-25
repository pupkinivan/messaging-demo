package com.ivanpupkin.usersigninservice.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInResponse {
    private String username;
    private String status;
}
