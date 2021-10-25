package com.ivanpupkin.usersigninservice.controller;

import com.ivanpupkin.usersigninservice.models.dto.UserDeletionRequest;
import com.ivanpupkin.usersigninservice.models.dto.UserSignInRequest;
import com.ivanpupkin.usersigninservice.models.dto.UserSignInResponse;
import com.ivanpupkin.usersigninservice.service.UserSignInService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users/sign-in")
@RequiredArgsConstructor
public class UserSignInController {
    private final UserSignInService service;

    @PostMapping
    public ResponseEntity<UserSignInResponse> signIn (@RequestBody @Validated UserSignInRequest request) {
        return service.signIn(request);
    }

    @DeleteMapping
    public ResponseEntity<UserSignInResponse> deleteuser(@RequestBody @Validated UserDeletionRequest request) {
        return service.deleteUser(request);
    }
}
