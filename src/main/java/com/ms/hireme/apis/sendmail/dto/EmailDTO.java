package com.ms.hireme.apis.sendmail.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.ms.hireme.apis.interview.dto.InterviewCreateDTO;
import com.ms.hireme.apis.interview.dto.InterviewDTO;
import com.ms.hireme.apis.interview.dto.InterviewUpdateDTO;

public class EmailDTO {

    private String ownerRef;
    private String subject;
    private String text;
    private String emailTo;
    private String emailFrom;

    public EmailDTO(){}

    public EmailDTO(String ownerRef, String emailFrom, String emailTo, String subject, String text) {
        this.ownerRef = ownerRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public EmailDTO(InterviewDTO interviewDTO){
        this.ownerRef = interviewDTO.getInterviewer().getName();
        this.emailFrom = "apihireme@gmail.com";
        this.emailTo = interviewDTO.getInterviewer().getEmail();
        this.subject = "Cancelamento de entrevista";
        this.text = "A entrevista de" + getDateFormat(interviewDTO.getAppointment()) +" foi cancelada";
    }

    public EmailDTO(InterviewCreateDTO interviewDTO){
        this.ownerRef = interviewDTO.getInterviewer().getName();
        this.emailFrom = "apihireme@gmail.com";
        this.emailTo = interviewDTO.getInterviewer().getEmail();
        this.subject = "Pedido de entrevista";
        this.text = "Cópia da mensagem original: " + interviewDTO.getDescription() + " / Data e horário da entrevista: " + getDateFormat(interviewDTO.getAppointment()) + " [Obs: Desconsiderar este e-mail; é apenas hipotético]";
    }

    public EmailDTO(InterviewUpdateDTO interviewDTO){
        this.ownerRef = interviewDTO.getInterviewer().getName();
        this.emailFrom = "apihireme@gmail.com";
        this.emailTo = interviewDTO.getInterviewer().getEmail();
        this.subject = "Atualização da entrevista";
        this.text = "Cópia da mensagem original: " + interviewDTO.getDescription() + " / Data e horário da entrevista: " + getDateFormat(interviewDTO.getAppointment()) + " [Obs: Desconsiderar este e-mail; é apenas hipotético]";
    }

    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateFormat(Instant instant){
        LocalDateTime datetime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        String formatted = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(datetime);
        return formatted;
    }
    
    
}
