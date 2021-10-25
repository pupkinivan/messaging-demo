package com.ivanpupkin.usersigninservice.models.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDeletionRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
