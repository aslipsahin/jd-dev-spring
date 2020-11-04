package com.cyber.services;

import com.cyber.interfaces.Course;
import com.cyber.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {

    /*
    This class contains setter injections. I added a sample for constructor injection and some other details into
     Java class.
     */

    private ExtraSessions extraSessions;

    @Autowired
    public void setExtraSessions(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (22 + extraSessions.getHours()));
    }

}
