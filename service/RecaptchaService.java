package com.define.definepage.service;

public interface RecaptchaService {
    boolean verifyRecaptcha(String recaptchaToken);
}
