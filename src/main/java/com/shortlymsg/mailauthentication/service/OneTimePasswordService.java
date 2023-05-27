package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OneTimePasswordService {

    public String generateOneTimePassword() {

        return String.valueOf(100000
                + new Random().nextInt(900000));
    }
}
