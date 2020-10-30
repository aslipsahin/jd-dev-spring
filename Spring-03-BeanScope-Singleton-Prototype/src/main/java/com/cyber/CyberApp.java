package com.cyber;

import com.cyber.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CyberApp {
    public static void main(String[] args) {

        /*
        There are two popular scope models in Spring; singleton and prototype
        There is a single bean object in singleton for a specific container.
        A new bean object is created each time in the container in prototype.
        The default scope is Singleton and you don't have to add the scope as singleton
         */
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course1 = container.getBean("java", Course.class);
        Course course2 = container.getBean("java", Course.class);

        System.out.println("Pointing to the same object: " + (course1 == course2));
        System.out.println("Memory location for the course1: " + course1);
        System.out.println("Memory location for the course2: " + course2);

    }
}
