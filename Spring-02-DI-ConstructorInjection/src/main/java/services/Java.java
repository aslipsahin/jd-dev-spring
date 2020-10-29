package services;

import interfaces.Course;
import interfaces.ExtraSessions;

public class Java implements Course {

    /*
    there are three types of injections. the first one is Constructor injection.
    In this module i am practicing just Constructor Injection.
     */
    /*
    in getTeachHours() we are calling getHours() method on the object. We can use officeHours or extraSessions objects.
    the best practice is to use extraSessions object, because this is the interface used as reference type and if there
    is another class implementing this interface, it will be more dynamic this way.
    And remember you are injecting the class type and object in config.xml file in java beans.
    so if you want to inject another object, you will change the constructor-arg ref in the config.xml bean.

    REMEMBER ALWAYS DO YOUR INJECTIONS THROUGH INTERFACES.

    you can inject multiple interfaces in the bean
     */
//    OfficeHours officeHours;
//
//    public Java(OfficeHours officeHours){
//        this.officeHours = officeHours;
//    }
//
//    @Override
//    public void getTeachingHours() {
//        System.out.println("Weekly Teaching Hours: " + (20 + officeHours.getHours()));
//    }

    ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions){
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours: " + (20 + extraSessions.getHours()));
    }
}
