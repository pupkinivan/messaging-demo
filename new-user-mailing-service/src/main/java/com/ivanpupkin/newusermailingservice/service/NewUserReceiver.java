package com.ivanpupkin.newusermailingservice.service;

import com.ivanpupkin.newusermailingservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserReceiver implements RabbitListenerConfigurer {

    @RabbitListener(queues = "user.new")
    public void receivedNewUserMessage(User user) {
        System.out.println("Received a new user!");
        System.out.println(user);
    }

    @RabbitListener(queues = "user.deleted")
    public void receivedDeletedUserMessage(User user) {
        System.out.println("An User has been deleted.");
        System.out.println(user);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
