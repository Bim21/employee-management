package com.ncc.service;

import com.ncc.dto.MailDTO;

public interface IEmailService {
    String sendEmail(MailDTO mailDTO);
    String sendEmailWithHTML(MailDTO mailDTO, String templateName);

}
