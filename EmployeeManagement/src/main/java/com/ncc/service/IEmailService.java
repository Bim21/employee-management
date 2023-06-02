package com.ncc.service;

public interface IEmailService {
    void sendRegistrationUserConfirm(String email);

    void sendResetPassword(String email);

        void sendEmail(String to, String subject, String content);



}
