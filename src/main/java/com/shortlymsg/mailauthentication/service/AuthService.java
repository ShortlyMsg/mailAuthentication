package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.dto.AuthDto;
import com.shortlymsg.mailauthentication.entity.User;
import com.shortlymsg.mailauthentication.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final EmailSenderService emailSenderService;

    public AuthService(UserRepository userRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.emailSenderService = emailSenderService;
    }

    public AuthDto authenticate(AuthDto authDto){
        User user = userRepository.findByMail(authDto.getMail());
        return Optional.ofNullable(user)
                .filter(u -> u.getOneTimePassword().equals(authDto.getToken()))
                .map(u -> {
                    emailSenderService.sendEmail(authDto.getMail(),
                            "Authentication",
                            "Dear \t"
                                    +user.getUserName()
                                    +"\nAuthentication is successful. You can login now with your Email and Password.");
                    return authDto;
                })
                .orElseThrow(() -> new IllegalArgumentException("Authentication is not successful"));
    }


    public User findByMail(String mail) {
        return userRepository.findByMail(mail);
    }
}
