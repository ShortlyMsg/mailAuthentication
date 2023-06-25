package com.shortlymsg.mailauthentication.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(unique = true, name = "mail")
    private String mail;

    @Column(unique = true, name = "user_name", length = 25)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
