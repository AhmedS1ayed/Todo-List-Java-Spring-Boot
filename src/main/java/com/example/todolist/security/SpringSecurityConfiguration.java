package com.example.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;
import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration
{
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
        UserDetails userDetails1 =   createUserDetails("Travis","ty");
        UserDetails userDetails2 =   createUserDetails("Musashi","ty");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }
    @Bean
    public PasswordEncoder passwordEncoder_()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }
    private UserDetails createUserDetails(String name , String password)
    {
        Function<String,String> passwordEnconderx = input -> passwordEncoder_().encode(input);
        UserDetails userDetails =   User.builder()
                .passwordEncoder(passwordEnconderx)
                .username(name)
                .password(password)
                .roles("ADMIN", "USER")
                .build();
        return userDetails;
    }
}
