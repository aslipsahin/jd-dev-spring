package com.cyber.services;

import com.cyber.interfaces.Course;
import com.cyber.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Java implements Course {

    /*
    How I inject in DI-ConstructorInjection in config.xml file
        <bean id="java" class="services.Java">
            <constructor-arg ref="officeHours"></constructor-arg>
        </bean>
       In this module i am practicing autowired annotation. @Autowired will do injection.
       Again an autowire can work in 3 ways, the same 3 different injection ways, same with config.xml
       The first one is constructor injection like in this class.
       If there is one constructor in the class, @Autowired will be default and you do not have to add it to the top
       of the constructor. But if there are multiple constructor you have use the annotation on the top of one of the
       constructors.
       The second one is setter injection. I added a sample for this into Selenium class.
       The third one is field injection. I added a sample for this into Python class.
     */

    private ExtraSessions extraSessions;

    @Autowired
    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + extraSessions.getHours()));
    }

}
