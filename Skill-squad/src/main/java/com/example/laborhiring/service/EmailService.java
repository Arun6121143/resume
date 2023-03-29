package com.example.laborhiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendMailPass(String sendMail, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("menonarun23@gmail.com");
        message.setTo(sendMail);
        message.setText(password);
        message.setSubject("Your Password");
        mailSender.send(message);
    }

}
