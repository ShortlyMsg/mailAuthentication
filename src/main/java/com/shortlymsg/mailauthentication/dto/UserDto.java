package com.shortlymsg.mailauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String id;
    private String mail;
    private String userName;
    private String password;
    private LocalDateTime creationDate;
}
