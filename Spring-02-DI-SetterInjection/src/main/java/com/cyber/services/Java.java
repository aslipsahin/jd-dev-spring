package com.cyber.services;

import com.cyber.interfaces.Course;

public class Java implements Course {

    /*
    There are three types of injections.
    The first one is Constructor Injection.
    The second one is Setter Injection
    In this module i am practicing Setter Injection.
     */

    private OfficeHours officeHours;

    public OfficeHours getOfficeHours() {
        return officeHours;
    }

/*
    in the config.xml file
    <property name="officeHours" ref="officeHours"></property>
    * property name is actually the setter method name.
        for instance in this example the setter method name is setOfficeHours() --> remove "set" from the method name
        and property name is going to look for the rest of the method name which is "office hours"
    * ref is the object of bean that i am trying to inject in. Meaning spring framework is going to look into
     config.xml file to find the bean named officeHours in this situation and inject it to officeHour setter method.

 */
    public void setOfficeHours(OfficeHours officeHours) { //set + officeHours
        this.officeHours = officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours: " + (20 + officeHours.getHours()));
    }

    /*
    instead of adding getters or setters we can add @Data annotation from lombok library to the above of the class name,
     it will create setter and getter and tostring behind the code
     */
}
