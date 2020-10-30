package com.cyber.services;

import com.cyber.interfaces.Course;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Java implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours: 20");
    }

    public void myInitMethod(){
        System.out.println("Executing init method");
    }

//    destroy method is going to run after i kill the container in the runner class which is CyberApp in my project
//            ((ClassPathXmlApplicationContext)container).close();

    public void myDestroyMethod(){
        System.out.println("Executing destroy method");
    }
}
