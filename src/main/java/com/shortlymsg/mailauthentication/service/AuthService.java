package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.dto.AuthDto;
import com.shortlymsg.mailauthentication.entity.User;
import com.shortlymsg.mailauthentication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthDto authenticate(AuthDto authDto){
        User user = userRepository.findByMail(authDto.getMail());
        authDto.getToken().equals(user.getOneTimePassword());
        return authDto;
    }

    public User findByMail(String mail) {
        return userRepository.findByMail(mail);
    }
}
