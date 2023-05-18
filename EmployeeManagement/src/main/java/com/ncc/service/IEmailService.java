package com.ncc.service;

import com.ncc.dto.EmployeeCheckinInfoDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IEmailService {
        void sendEmail(String to, String subject, String content);


}
