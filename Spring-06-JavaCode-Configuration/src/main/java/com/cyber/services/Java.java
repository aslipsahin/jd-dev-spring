package com.cyber.services;

import com.cyber.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours 30");
    }
}
