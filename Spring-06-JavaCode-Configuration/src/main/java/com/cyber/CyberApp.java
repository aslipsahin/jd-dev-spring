package com.cyber;

import com.cyber.configs.CyberAppConfig;
import com.cyber.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyberApp {
    public static void main(String[] args) {
        /*
        In xml and java annotation configuration i use the following line to create the container.
                ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
        But since i do not use config.xml file in Java Code annotation any more,
        i will use a different class AnnotationConfigApplicationContext() and specify the CyberappConfig.class name here.

        1. Create container in the runner class.
                ApplicationContext container = new AnnotationConfigApplicationContext(CyberAppConfig.class);
        2. Add the following annotations in the CyberAppConfig.java class in the class level to say spring which package to scan.
                    @Configuration
                    @ComponentScan("com.cyber")
        3. Add @Component annotation in the class level for classes that i want to create beans.

        */

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

        ApplicationContext container = new AnnotationConfigApplicationContext(CyberAppConfig.class);

        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

    }
}
