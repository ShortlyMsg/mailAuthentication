package com.shortlymsg.mailauthentication.controller;

import com.shortlymsg.mailauthentication.dto.AuthDto;
import com.shortlymsg.mailauthentication.service.AuthService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<AuthDto> authenticate(AuthDto authDto){
        log.info("Inside authenticate method of AuthController");
        return ResponseEntity.ok(authService.authenticate(authDto));
    }
}
