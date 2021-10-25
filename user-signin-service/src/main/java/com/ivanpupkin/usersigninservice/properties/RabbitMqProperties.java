package com.ivanpupkin.usersigninservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.rabbitmq")
@Getter
@Setter
public class RabbitMqProperties {
    private String host;
    private String username;
    private String password;
    private String port;
    private RabbitMqTemplate template;

    @Getter
    @Setter
    public static class RabbitMqTemplate {
        private String exchange;
        private String routingKey;
    }
}
