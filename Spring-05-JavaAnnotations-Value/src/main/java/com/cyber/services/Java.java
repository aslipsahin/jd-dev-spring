package com.cyber.services;

import com.cyber.interfaces.Course;
import com.cyber.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Java implements Course {

    /*
    Injecting Values into fields - @Value
    This annotation is used for injecting values into fields in Spring-managed beans and it can be applied at the field
    or constructor/method parameter level.
    This annotation can be used in 3 different ways:
    1.	Injecting from annotation field meaning hard coding injection
        @Value(“J1”)
        private String batch;
    2.	Injecting from properties files
        @Value(“${instructor}”)
        private String instructor;
    3.	Injecting bunch of values from properties file
        @Value(“${days}”)
        private String[] days;]

    Remember, this @Value s will be searched in the properties file.
    */

    @Value("JD1")
    private String batch;

    @Value("${instructor)")
    private String instructor;

    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }

    @Value("${days}")
    private String[] days;

    private ExtraSessions extraSessions;

    @Autowired
    @Qualifier("officeHours")
    public void setExtraSessions( ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (20 + extraSessions.getHours()));
    }
}