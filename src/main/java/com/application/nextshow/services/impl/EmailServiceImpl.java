package com.application.nextshow.services.impl;

import com.application.nextshow.services.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {
        // Logic to send email
        System.out.printf("Email sent to %s with subject: %s\n%s\n", to, subject, body);
    }
}
