package com.ms.sendmail.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.ms.sendmail.model.Email;
import com.ms.sendmail.model.StatusEmail;
import com.ms.sendmail.repository.EmailRepository;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public Email sendEmail(Email email) {
        email.setSendDateEmail(Instant.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject((email.getSubject()));
            message.setText(email.getText());
            emailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        } catch( MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        } 
        return emailRepository.save(email);
    }
}