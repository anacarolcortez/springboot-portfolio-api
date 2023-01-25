package com.ms.hireme.apis.sendmail.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

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

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory cf, Jackson2JsonMessageConverter msgConvert){
        RabbitTemplate rbt = new RabbitTemplate(cf);
        rbt.setMessageConverter(msgConvert);
        return rbt;
    }
}
