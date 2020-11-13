package com.cyber;

import com.cyber.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CyberApp {

    /*
    1. Loading properties file in XML config
        <context:property-placeholder location=”classpath:application.properties”/>  this is to define the location
    of the properties. I will not need to add it if i use spring boot framework since it is gonna add it automatically.
    2. put the properties file in the resource folder.
    3. application.properties should be created if you are using spring framework but it is created automatically if
       you are using spring boot.
    4. In the application.properties file, there can be all connection string db, postgress, username, password, which
    db, which schema, environment details, which server we are using in UI...
    5. Whenever we start the application with the spring framework or spring boot, spring boot is gonna go directly to
    the application.properties file, this is the first step what spring&/boot will do. And it is gonna scan all
    property files. If it is a db connection it is gonna create db right way server modification, it is gonna do all
    server connections right away.

     */

    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("java", Course.class);
        System.out.println(course.toString());

    }

}
