package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.dto.UserDto;
import com.shortlymsg.mailauthentication.dto.converter.UserDtoConverter;
import com.shortlymsg.mailauthentication.entity.User;
import com.shortlymsg.mailauthentication.exception.UserNotFoundException;
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


    public UserDto saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        user.setCreationDate(LocalDateTime.now());
        return converter.convertToUserDto(userRepository.save(user));
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

    public User getUserById(String id) {
        log.info("Inside getUserById method of UserService");
        return userRepository.findById(id)
                .orElseThrow(
                () -> new UserNotFoundException("User could not find by id: " + id));
    }

    public User deleteUser(String id) {
        log.info("Inside deleteUser method of UserService");
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User could not find by id: " + id));
        userRepository.deleteById(id);
        return user;
    }

    public UserDto updateUserById(User user, String id) {
        log.info("Inside updateUserById method of UserService");
        User updateUser = userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User could not find by id: " + id));
        updateUser.setMail(user.getMail());
        updateUser.setUserName(user.getUserName());
        updateUser.setPassword(user.getPassword());
        return converter.convertToUserDto(userRepository.save(updateUser));
    }

}
