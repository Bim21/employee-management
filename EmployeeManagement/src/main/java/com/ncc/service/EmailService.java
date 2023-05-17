package com.ncc.service;

import com.ncc.entity.User;
import com.ncc.repository.RegistrationUserTokenRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService implements IEmailService {

    private IUserService userService;

    private RegistrationUserTokenRepository registrationUserTokenRepository;

    private JavaMailSender mailSender;
//    @Override
//    public void sendRegistrationUserConfirm(String email) {
//        User user = userService.findUserByEmail(email);
//        String token = registrationUserTokenRepository.findByUserId(user.getId());
//        String confirmationUrl = "http://localhost:8080/api/v1/users/activeUser?token=" + token;
//
//        String subject = "Xác nhận đăng ký Account";
//        String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n" + confirmationUrl;
//
//        sendEmail(email, subject, content);
//
//    }
//    private void sendEmail(final String recipientEmail, final String subject, final String content){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(recipientEmail);
//        message.setSubject(subject);
//        message.setText(content);
//
//        mailSender.send(message);
//    }
}
