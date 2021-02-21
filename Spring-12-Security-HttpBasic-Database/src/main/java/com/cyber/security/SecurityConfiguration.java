package com.cyber.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //defines what you are gonna authenticate
        http
                .authorizeRequests() //request should be authorized
                .antMatchers("index.html").permitAll() // antMatchers is used to give access to specific users. In this case, give access to everyone(permitAll()) for index.html
                .antMatchers("/profile/**").authenticated() // any person having access (authenticated()) has access to any html under profile package (profile/**)
                .antMatchers("/admin/**").hasRole("ADMIN") // just people with ADMIN role will have access to any html under admin folder
                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER") // people with ADMIN and MANAGER role will have access to any html under manager folder
                .and()
                .httpBasic();   //perform basic http authentication
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // this encoding type is the default one in spring
    }
}
