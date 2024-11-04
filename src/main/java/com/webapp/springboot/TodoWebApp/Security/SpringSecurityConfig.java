package com.webapp.springboot.TodoWebApp.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;


// Spring Security Configuration class
@Configuration
public class SpringSecurityConfig
{



    // In memory user details here users can be added to be able to login to the application
    @Bean
    public InMemoryUserDetailsManager createUser()
    {
     UserDetails userDetails1 = createNewUser("Ashir","dummy");
        UserDetails userDetails2 = createNewUser("Arslan","dummy");

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails createNewUser(String username,String password)
    {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);


        return User.builder()
                .passwordEncoder(passwordEncoder)
                .password(password)
                .username(username)
                .roles("USER","ADMIN")
                .build();
    }


    // Password encoder to encode password
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Filtering to allow JSP forms

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception
    {

        security.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());

        security.formLogin(withDefaults());
        security.csrf(AbstractHttpConfigurer::disable);
        security.headers(headers->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return security.build();
    }



}
