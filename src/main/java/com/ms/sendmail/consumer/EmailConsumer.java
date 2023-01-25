package com.ms.sendmail.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.sendmail.dto.EmailDTO;
import com.ms.sendmail.model.Email;
import com.ms.sendmail.service.EmailService;

@Component
public class EmailConsumer {
    
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDto){
        Email email = new Email();
        copyDtoToEntity(emailDto, email);
        emailService.sendEmail(email);
        System.out.println("Status do email: " + email.getStatusEmail().toString());
    }

    private void copyDtoToEntity(EmailDTO dto, Email entity){
        entity.setOwnerRef(dto.getOwnerRef());
        entity.setEmailFrom(dto.getEmailFrom());
        entity.setEmailTo(dto.getEmailTo());
        entity.setSubject(dto.getSubject());
        entity.setText(dto.getText());
    }
}
