package com.shortlymsg.mailauthentication.service;

import com.shortlymsg.mailauthentication.dto.UserDto;
import com.shortlymsg.mailauthentication.dto.converter.UserDtoConverter;
import com.shortlymsg.mailauthentication.entity.User;
import com.shortlymsg.mailauthentication.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(converter::convertToUserDto)
                .collect(Collectors.toList());
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User deleteUser(String id) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.deleteById(id);
        return user;
    }

    public User updateUser(String id, User user) {
        User oldUser = userRepository.findById(id).orElse(null);
        oldUser.setMail(user.getMail());
        return userRepository.save(oldUser);
    }



}
