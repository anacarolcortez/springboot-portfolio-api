package com.ms.sendmail.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    
    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter msgConvert(){
        return new Jackson2JsonMessageConverter();
    }
}
