package com.cyber.services;

import com.cyber.interfaces.Course;
import com.cyber.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Python implements Course {

    /*
    This class contains field injections. I added a sample for constructor injection and some other details into
     Java class and field injection into Selenium class.
     */

    @Autowired
    private ExtraSessions extraSessions;

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (13 + extraSessions.getHours()));
    }

}
