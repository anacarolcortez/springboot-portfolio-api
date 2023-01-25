package com.ms.hireme.apis.sendmail.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.hireme.apis.sendmail.model.Email;
import com.ms.hireme.apis.sendmail.model.StatusEmail;
import com.ms.hireme.apis.sendmail.repository.EmailRepository;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

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