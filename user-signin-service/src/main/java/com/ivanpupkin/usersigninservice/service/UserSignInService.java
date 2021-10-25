package com.ivanpupkin.usersigninservice.service;

import com.ivanpupkin.usersigninservice.mapper.UserMapper;
import com.ivanpupkin.usersigninservice.models.domain.User;
import com.ivanpupkin.usersigninservice.models.dto.UserDeletionRequest;
import com.ivanpupkin.usersigninservice.models.dto.UserSignInRequest;
import com.ivanpupkin.usersigninservice.models.dto.UserSignInResponse;
import com.ivanpupkin.usersigninservice.properties.RabbitMqProperties;
import com.ivanpupkin.usersigninservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Setter
public class UserSignInService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final RabbitTemplate rabbitTemplate;
    private final RabbitMqProperties rabbitMqProperties;

    public ResponseEntity<UserSignInResponse> signIn (UserSignInRequest request) {
        User user = mapper.mapUserSignInRequestToUser(request);
        UserSignInResponse response = new UserSignInResponse();
        response.setUsername(user.getUsername());
        if (!repository.existsById(user.getUsername()) && !repository.existsByEmailAddress(user.getEmailAddress())) {
            repository.save(user);
            sendCreatedToRabbitMq(user);
            response.setStatus("User created");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setStatus("Username or email address are already in use");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<UserSignInResponse> deleteUser (UserDeletionRequest request) {
        UserSignInResponse response = new UserSignInResponse();
        response.setUsername(request.getUsername());
        if (repository.existsById(request.getUsername())) {
            User existingUser = repository.findById(request.getUsername())
                    .get(); // Already checked for existence
            if (request.getPassword().equals(existingUser.getPassword())) {
                sendDeletedToRabbitMq(existingUser);
                repository.delete(existingUser);
                response.setStatus("User deleted");
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            } else {
                response.setStatus("Failed authentication");
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
            }
        } else {
            response.setStatus("The user does not exist");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    private void sendCreatedToRabbitMq(User user) {
        System.out.println("Sending new user...");
        System.out.println(user);
        rabbitTemplate.convertAndSend(
                rabbitMqProperties.getTemplate().getExchange(),
                "user.new",
                user);
    }

    private void sendDeletedToRabbitMq(User user) {
        System.out.println("Sending deleted user...");
        System.out.println(user);
        rabbitTemplate.convertAndSend(
                rabbitMqProperties.getTemplate().getExchange(),
                "user.deleted",
                user);
    }
}
