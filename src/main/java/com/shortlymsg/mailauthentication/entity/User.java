package com.shortlymsg.mailauthentication.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String mail;

}
