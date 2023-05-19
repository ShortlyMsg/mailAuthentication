package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.dto.UserDto;
import com.shortlymsg.mailauthentication.dto.converter.UserDtoConverter;
import com.shortlymsg.mailauthentication.entity.User2;
import com.shortlymsg.mailauthentication.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter converter;

    public UserService(UserRepository userRepository, UserDtoConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }


    public User2 saveUser(User2 user) {
        log.info("Inside saveUser method of UserService");
        user.setCreationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public List<UserDto> getAll() {
        log.info("Inside getAll method of UserService");
        return userRepository.findAll()
                .stream()
                .map(converter::convertToUserDto)
                .collect(Collectors.toList());
    }

/*    public List<User> getAllUsers() {
        return userRepository.findAll();
    }*/

    public User2 getUserById(String id) {
        log.info("Inside getUserById method of UserService");
        return userRepository.findById(id).orElse(null);
    }

    public User2 deleteUser(String id) {
        log.info("Inside deleteUser method of UserService");
        User2 user = userRepository.findById(id).orElse(null);
        userRepository.deleteById(id);
        return user;
    }

    public UserDto updateUserById(User2 user, String userId) {
        log.info("Inside updateUserById method of UserService");
        User2 updateUser = userRepository.findById(userId).orElse(null);
        updateUser.setMail(user.getMail());
        updateUser.setPassword(user.getPassword());
        return converter.convertToUserDto(userRepository.save(updateUser));
    }

}
