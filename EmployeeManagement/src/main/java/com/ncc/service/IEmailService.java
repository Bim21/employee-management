package com.ncc.service;

import com.ncc.dto.MailDTO;

public interface IEmailService {
<<<<<<< HEAD
    String sendEmail(MailDTO mailDTO);
    String sendEmailWithHTML(MailDTO mailDTO, String templateName);
=======
        void sendEmail(String to, String subject, String content);

>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b

}
