package com.ncc.service;

<<<<<<< HEAD
import com.ncc.constants.MessageConstant;
import com.ncc.dto.MailDTO;
=======
>>>>>>> a6e0e48575538adf49a80e58ef09647b5a4b563b
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService implements IEmailService {
    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public String sendEmail(MailDTO mailDTO) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(mailDTO.getTo());
            message.setSubject(mailDTO.getSubject());
            message.setText(mailDTO.getContent());
            mailSender.send(message);
            return MessageConstant.SEND_MAIL_DONE;

        }catch (Exception e){
            return MessageConstant.SEND_MAIL_FAIL;
        }
    }

    @Override
    public String sendEmailWithHTML(MailDTO mailDTO, String templateName) {
        return null;
    }

}
