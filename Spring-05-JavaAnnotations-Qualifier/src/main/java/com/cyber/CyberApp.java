package com.cyber;

import com.cyber.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CyberApp {

    /*
            ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
    Spring is gonna create beans in config.xml file
        <context:component-scan base-package="com.cyber.services"/>
    There is base-package keyword in config.xml file. That means spring is gonna create beans in this package
    Spring is going to look for some annotations to understand which classes need beans to be created.
    In this module, i am using @Component annotation for this purpose.
            @Component
            public class Java implements Course {
                private ExtraSessions extraSessions;
                @Override
                public void getTeachingHours() {
                    System.out.println("Weekly teaching hours : " + extraSessions.getHours());
                }
            }
     In Java class, Java has dependency in extraSessions object. So i need to do dependency injection.
     I will use constructor injection in this sample and use @Autowired annotations to inject the object.
            @Component
            public class Java implements Course {
                private ExtraSessions extraSessions;
                @Autowired
                public Java(ExtraSessions extraSessions) {
                    this.extraSessions = extraSessions;
                }
                @Override
                public void getTeachingHours() {
                    System.out.println("Weekly teaching hours : " + extraSessions.getHours());
                }
            }
     However, if Java class has dependency the extraSessions object which has two implementations MockInterviewHours
     and OfficeHours, then the compiler gives error. In this case i have to use another annotation '@Qualifier'
     to specify which class type to use. I can inject this annotation in 3 ways; constructor, setter and field.

    Field:
            @Component
            public class Java implements Course {
                @Autowired
                @Qualifier("officeHours")
                private ExtraSessions extraSessions;
                @Override
                public void getTeachingHours() {
                    System.out.println("Weekly teaching hours : " + (20 + extraSessions.getHours()));
                }
            }

    Constructor:
                @Component
            public class Java implements Course {
                private ExtraSessions extraSessions;
                public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
                    this.extraSessions = extraSessions;
                }
                @Override
                public void getTeachingHours() {
                    System.out.println("Weekly teaching hours : " + (20 + extraSessions.getHours()));
                }
            }

    Setter:
            @Component
            public class Java implements Course {
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

        @Qualifier("officeHours") ExtraSessions extraSessions
       @Qualifier annotation says: If you find different extraSession implementations use this officeHours
     */
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

    }

}
