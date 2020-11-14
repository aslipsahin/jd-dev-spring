package com.cyber;

import com.cyber.configs.CyberAppConfig;
import com.cyber.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyberApp {
    public static void main(String[] args) {
        /*
        You can do dependency injection in 2 ways.
        1.
        Use @Component for the classes to be created the beans and @Autowired for the beans you want to dependency
        injection. for this case @Component to Java and @Autowired to OfficeHours for extraSessions object in Java class
            @Component
            public class Java implements Course {
                @Autowired
                private ExtraSessions extraSessions;
        2.
        Use @Bean. Eg Here officeHours object is injected to java() method by using officeHours() method.
            @Bean
            public Java java(){
                return new Java(officeHours());
            }

            @Bean
            public OfficeHours officeHours(){
                return new OfficeHours();
            }
         */

        ApplicationContext container = new AnnotationConfigApplicationContext(CyberAppConfig.class);

        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

    }
}
