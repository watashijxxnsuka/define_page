package com.define.definepage.service;

import com.define.definepage.dto.EmailDto;

public interface EmailService {
    void sendEmail(EmailDto emailDto);
    void sendFooterEmail(EmailDto emailDto);
}
