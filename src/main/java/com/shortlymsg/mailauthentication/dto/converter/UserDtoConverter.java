package com.shortlymsg.mailauthentication.dto.converter;

import com.shortlymsg.mailauthentication.dto.UserDto;
import com.shortlymsg.mailauthentication.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .mail(user.getMail())
                .userName(user.getUserName())
                .password(user.getPassword())
                .creationDate(user.getCreationDate())
                .build();
    }

    public List<UserDto> convertToUserDto(List<User> user) {
        return user.stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

}
