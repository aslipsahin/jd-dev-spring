package com.cyber;

import com.cyber.configs.CyberAppConfig;
import com.cyber.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyberApp {
    public static void main(String[] args) {
/*
        1.	Using @Value annotation is the same as JavaAnnotations, look at Java class.
        2.	Create a properties file and add @PropertySource(“classpath:”application.properties”) into config class
        which is CyberAppConfig in my case like the following:
            @Configuration
            @ComponentScan("com.cyber")
            @PropertySource("classpath:application.properties")
            public class CyberAppConfig {
*/

        ApplicationContext container = new AnnotationConfigApplicationContext(CyberAppConfig.class);

        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();
        System.out.println(course.toString());

    }
}
