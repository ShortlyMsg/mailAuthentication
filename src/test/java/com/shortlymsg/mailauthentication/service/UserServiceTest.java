package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.dto.UserDto;
import com.shortlymsg.mailauthentication.dto.converter.UserDtoConverter;
import com.shortlymsg.mailauthentication.entity.User;
import com.shortlymsg.mailauthentication.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;
    private UserDtoConverter converter;

    @BeforeEach
    public void setUp(){
        userRepository = Mockito.mock(UserRepository.class);
        converter = Mockito.mock(UserDtoConverter.class);

        userService = new UserService(userRepository, converter);
    }
    @Test
    void testSaveUser() {

    }

    @AfterEach
    public void tearDown(){

    }
}