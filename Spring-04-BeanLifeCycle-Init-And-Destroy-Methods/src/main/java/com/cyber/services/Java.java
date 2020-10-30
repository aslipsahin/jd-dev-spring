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
//    i have to down cast container since its reference type is ApplicationContext interface and the class type is
//    ClassPathXmlApplicationContext meaning it has access to ApplicationContext but close() method belongs to
//    ClassPathXmlApplicationContext.

    public void myDestroyMethod(){
        System.out.println("Executing destroy method");
    }
}
