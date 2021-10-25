package com.ivanpupkin.newusermailingservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.rabbitmq")
@Getter
@Setter
public class RabbitProperties {
    private String username;
    private String password;
    private String host;
    private RabbitMqTemplate template;

    @Getter
    @Setter
    public static class RabbitMqTemplate {
        private String defaultReceiveQueue;
        private String exchange;
        private String routingKey;
    }
}
