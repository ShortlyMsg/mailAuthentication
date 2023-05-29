package com.shortlymsg.mailauthentication.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
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
        var mail: String? = null,

        @Column(unique = true, name = "user_name", length = 25)
        @Pattern(regexp = "^[a-z0-9._]+$", message = "Username can only contain lowercase letters, numbers, '.', and '_'")
        var userName: String? = null,

        @NotBlank(message = "{password.new.not-blank}")
        @Column(name = "password")
        var password: String,

        @Column(name = "one_time_password")
        var oneTimePassword: String? = null,

        @Column(name = "creation_date")
        var creationDate: LocalDateTime,
){
    constructor() : this(null, "", "","","", LocalDateTime.now())
}
