package com.shortlymsg.mailauthentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("msg")
                .password(encoder.encode("123"))
                .roles("ADMIN", "USER")
                .build();
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html","/error").permitAll()
                //.requestMatchers("/users").authenticated()
                .requestMatchers(HttpMethod.POST,"/users/**").hasRole("USER")
                .requestMatchers("/v1/users/**", "/v1/email/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
