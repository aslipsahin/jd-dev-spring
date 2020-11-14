package com.cyber.services;

import com.cyber.interfaces.Course;
import com.cyber.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

public class Java implements Course {

    private ExtraSessions extraSessions;

    @Value("JD1")
    private String batch;

    @Value("${instructor}")
    private String instructor;

    @Value("${days}")
    private String[] days;

    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + extraSessions.getHours()));
    }

}
