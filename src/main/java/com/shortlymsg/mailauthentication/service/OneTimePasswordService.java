package com.shortlymsg.mailauthentication.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class OneTimePasswordService {

    public String generateOneTimePassword() {

        return String.valueOf(100000
                + new SecureRandom().nextInt(900000));
    }
}
