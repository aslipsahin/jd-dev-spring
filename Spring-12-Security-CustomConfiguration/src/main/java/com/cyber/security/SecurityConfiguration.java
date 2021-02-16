package com.cyber.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*
    Normally sprint is using WebSecurityConfigurerAdapter class to create username and password automatically.
    I extend this class and override methods here to customize the credentials.

     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //defines what you are gonna authenticate
        http
                .authorizeRequests() //request should be authorized
                .anyRequest().authenticated()   //incoming request be authenticated
                .and()
                .httpBasic();   //perform basic http authentication
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        //who is your users, what are the credentials
        auth
                .inMemoryAuthentication()
//                .withUser("admin").password("admin123").roles("ADMIN") -> spring does not approve sending passwords to the system without encoding
                .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
                .and()
                .withUser("asli").password(passwordEncoder().encode("asli123")).roles("USER");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // this encoding type is the default one in spring
    }
}
