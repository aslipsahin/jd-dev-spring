package com.cyber.services;

import com.cyber.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    /*
    We are gonna add the following line into config.xml file. base-package tells spring
    which package it should scan for java annotations. In this case, it is com.cyber.services package
        <context:component-scan base-package="com.cyber.services"/>
    Then  add @Component annotation in class base for the classes that you want to create beans.

    You can add different packages into base-package by adding comma between packages.
     */

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours: 30");
    }
}
