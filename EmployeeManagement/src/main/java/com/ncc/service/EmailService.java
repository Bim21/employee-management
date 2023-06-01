package com.ncc.service;

<<<<<<< HEAD
public class EmailService implements IEmailService{
    @Override
    public void sendRegistrationUserConfirm(String email) {

    }

    @Override
    public void sendResetPassword(String email) {

    }
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271
}
