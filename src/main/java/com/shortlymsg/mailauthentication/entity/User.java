package com.shortlymsg.mailauthentication.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id")
    private String id;

    @Column(name="mail")
    private String mail;

    @Column(name="password")
    private String password;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

}
