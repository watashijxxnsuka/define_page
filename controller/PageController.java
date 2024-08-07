package com.define.definepage.controller;

import com.define.definepage.dto.EmailDto;
import com.define.definepage.service.EmailService;
import com.define.definepage.service.RecaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pages")
public class PageController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private RecaptchaService recaptchaService;

    @GetMapping(value = "/contact.do")
    public String contact() {
        return "/pages/contact"; // contact.jsp 경로 설정
    }

    @GetMapping(value = "/fu_pj.do")
    public String fu_pj() {
        return "/pages/fu_pj"; // fu_pj.jsp 경로 설정
    }

    @GetMapping(value = "/team_intro.do")
    public String team_intro() {
        return "/pages/team_intro"; // team_intro.jsp 경로 설정
    }

    @GetMapping(value = "/team_pj.do")
    public String team_pj() {
        return "/pages/team_pj";
    }


    @PostMapping("/contact.do")
    public String sendEmail(@ModelAttribute EmailDto emailDto, Model model) {
        if ("footer_contact".equals(emailDto.getFormType())) {
            // Footer 폼 처리 로직
            emailService.sendFooterEmail(emailDto);
        } else {
            boolean isHuman = recaptchaService.verifyRecaptcha(emailDto.getRecaptchaToken());
            if (!isHuman) {
                model.addAttribute("message", "reCAPTCHA verification failed. Please try again.");
                return "/pages/contact";
            }
            // 기본 폼 처리 로직
            emailService.sendEmail(emailDto);
        }

        model.addAttribute("message", "성공적으로 전송되었습니다!");
        return "/pages/contact";

    }

}