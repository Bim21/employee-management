package com.ncc.service;

public interface IEmailService {
<<<<<<< HEAD
    void sendRegistrationUserConfirm(String email);

    void sendResetPassword(String email);
=======
        void sendEmail(String to, String subject, String content);

>>>>>>> 6a06570c2a08b7267a1bf4bef7c9b7abd3d36271

}
