package com.spring.codebuild.Service;

import com.spring.codebuild.models.EmailDetails;

public interface EmailService {
    String sendSimpleMail(String toAdress, String subject, String message);

    String sendMailWithAttachment(EmailDetails details);
}
