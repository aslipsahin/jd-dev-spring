package com.cyber.services;

import com.cyber.interfaces.Course;
import org.springframework.stereotype.Component;

public class Selenium implements Course {
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours 22");
    }
}
