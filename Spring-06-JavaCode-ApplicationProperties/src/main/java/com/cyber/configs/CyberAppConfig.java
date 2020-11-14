package com.cyber.configs;

import com.cyber.interfaces.ExtraSessions;
import com.cyber.services.Java;
import com.cyber.services.OfficeHours;
import com.cyber.services.Selenium;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.cyber")
@PropertySource("classpath:application.properties")
public class CyberAppConfig {

    @Bean
    public Java java(){
        return new Java(extraSessions());
    }

    @Bean
    public Selenium selenium(){
        return new Selenium();
    }

    @Bean //You do not need to add @Bean here
    public ExtraSessions extraSessions(){
        return new OfficeHours();
    }

}
