package com.shortlymsg.mailauthentication.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id")
        val id: String? = "",

        @Column(name = "mail")
        var mail: String,

        @NotBlank(message = "{password.new.not-blank}")
        @Column(name = "password")
        var password: String,

        @Column(name = "creation_date")
        var creationDate: LocalDateTime,
){
    constructor() : this(null, "", "", LocalDateTime.now())
}

