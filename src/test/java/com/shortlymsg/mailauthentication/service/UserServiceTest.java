package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.dto.converter.UserDtoConverter;
import com.shortlymsg.mailauthentication.entity.User2;
import com.shortlymsg.mailauthentication.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

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
    void testGetUserById_Exists() {

        String userId = "123";
        User2 expectedUser = new User2();
        when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

        User2 result = userService.getUserById(userId);

        assertEquals(expectedUser, result);
        verify(userRepository, times(1)).findById(userId);
    }

    @AfterEach
    public void tearDown(){

    }
}