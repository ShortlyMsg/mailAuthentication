package com.shortlymsg.mailauthentication.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
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

        @Column(unique = true, name = "mail")
        var mail: String,

        @Column(unique = true, name = "user_name", length = 25)
        var userName: String,

        @Column(name = "password")
        var password: String,

        @Column(name = "one_time_password")
        var oneTimePassword: String,

        @Column(name = "creation_date")
        var creationDate: LocalDateTime,
){
    constructor() : this(null, "", "","","", LocalDateTime.now())
}
