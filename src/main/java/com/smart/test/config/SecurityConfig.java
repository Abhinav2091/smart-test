package com.smart.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
/*
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //Authenticate all the api
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        //setting defaults for entering basic Authenticate
        //a pop up will generate here for username and password
        httpSecurity.httpBasic(Customizer.withDefaults());
        //disable CSRF to access post and put api
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
