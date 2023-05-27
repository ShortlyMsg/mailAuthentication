package com.shortlymsg.mailauthentication.controller;

import com.shortlymsg.mailauthentication.service.EmailSenderService;
import com.shortlymsg.mailauthentication.service.OneTimePasswordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailSenderController {

    private final EmailSenderService senderService;
    private final OneTimePasswordService passwordService;


    public EmailSenderController(EmailSenderService senderService, OneTimePasswordService passwordService) {
        this.senderService = senderService;
        this.passwordService = passwordService;
    }

    @PostMapping
    public void sendMail(){
        senderService.sendEmail("42msg42@gmail.com"
                ,"Hey !!"
                ,"One time password: "
                        +passwordService.generateOneTimePassword()
                        +" you can use it for the register.");
    }
}
