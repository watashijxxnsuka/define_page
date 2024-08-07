package com.define.definepage.service.impl;

import com.define.definepage.dto.EmailDto;
import com.define.definepage.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("devteamdefine@gmail.com");
        message.setSubject("New Contact Message from " + emailDto.getName());

        StringBuilder emailContent = new StringBuilder();
        emailContent.append("문의 유형: ").append(emailDto.getCategory()).append("\n")
                .append("포지션: ").append(emailDto.getPriority()).append("\n")
                .append("구독 동의: ").append(emailDto.isSubscribe() ? "Yes" : "No").append("\n")
                .append("\n\n")
                .append("Message: ").append(emailDto.getMessage()).append("\n\n")
                .append("From: ").append(emailDto.getName()).append(" (").append(emailDto.getEmail()).append(")");

        message.setText(emailContent.toString());
        mailSender.send(message);
    }

    @Override
    public void sendFooterEmail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("devteamdefine@gmail.com");
        message.setSubject("New Contact FooterMessage from " + emailDto.getName());

        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Message: ").append(emailDto.getMessage()).append("\n\n")
                .append("From: ").append(emailDto.getName()).append(" (").append(emailDto.getEmail()).append(")");

        message.setText(emailContent.toString());
        mailSender.send(message);
    }
}
