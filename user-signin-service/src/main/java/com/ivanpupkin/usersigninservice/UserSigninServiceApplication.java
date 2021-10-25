package com.ivanpupkin.usersigninservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableRabbit
@EnableMongoRepositories
@ConfigurationPropertiesScan
public class UserSigninServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSigninServiceApplication.class, args);
	}

}
