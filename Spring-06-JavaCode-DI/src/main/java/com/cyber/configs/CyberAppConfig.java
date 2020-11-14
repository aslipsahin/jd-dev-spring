package com.cyber.configs;

import com.cyber.interfaces.ExtraSessions;
import com.cyber.services.Java;
import com.cyber.services.OfficeHours;
import com.cyber.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cyber")
public class CyberAppConfig {
    /*
        @Bean or @Component:
            @Component is added in the class level for classes that I want to create beans
            @Bean annotation on the top of the method that you want to create a bean and add this method in the config
             class which is CyberAppConfig.java in this case. This annotation is not preferred much in regular app
             classes but rather than that it is used for third party classes and third party classes mostly cannot
             be manipulated meaning you cannot add @Component annotation on the classes. So it is better to add the
             following method in to the config class and use @Bean annotation. Eg for Java class bean:
                    @Bean
                    public Java java(){
                        return new Java();
                    }
    */

    /*
    Here officeHours object is injected to java() method by using officeHours() method.
     */

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

    /*
    I can use the code above or below but the upper one is a better practice since i use here interface
     */

//    @Bean
//    public Java java(){
//        return new Java(officeHours());
//    }
//
//    @Bean
//    public Selenium selenium(){
//        return new Selenium();
//    }
//
//    @Bean //You do not need to add @Bean here
//    public OfficeHours officeHours(){
//        return new OfficeHours();
//    }


}
