package com.shortlymsg.mailauthentication.controller;

import com.shortlymsg.mailauthentication.dto.UserDto;
import com.shortlymsg.mailauthentication.entity.User;
import com.shortlymsg.mailauthentication.service.EmailSenderService;
import com.shortlymsg.mailauthentication.service.OneTimePasswordService;
import com.shortlymsg.mailauthentication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/email")
public class EmailSenderController {

    private final EmailSenderService senderService;
    private final OneTimePasswordService passwordService;
    private final UserService userService;


    public EmailSenderController(EmailSenderService senderService, OneTimePasswordService passwordService, UserService userService) {
        this.senderService = senderService;
        this.passwordService = passwordService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUserAndSendMail(@RequestBody User user){
        log.info("Inside saveUserAndSendMail method of EmailSenderController");
        senderService.sendEmail(user.getMail()
                ,"Hey "+user.getUserName()
                ,"Your account has been created at \n{"
                        +user.getCreationDate()
                        +"}. \nPlease use the following one time password (OTP) for authentication:  "
                        +passwordService.generateOneTimePassword()
                        +"\nYou can use this OTP for the registration process.");
        return ResponseEntity.ok(userService.saveUser(user));
    }

}
