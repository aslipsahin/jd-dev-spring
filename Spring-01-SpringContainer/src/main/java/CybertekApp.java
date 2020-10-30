import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.FullTimeMentor;

public class CybertekApp {
    public static void main(String[] args) {

        //there are 3 ways to create a container

        //WAY 1
        //create a bean in config.xml file under resources
        //<bean id="fullTimeMentor" class="services.FullTimeMentor"></bean>
        // id is the bean obj name and class is the full path of the class that the obj is gonna be created

        //create a container to to save all my beans i defined in config.file which is under resources
        BeanFactory container1 = new ClassPathXmlApplicationContext("config.xml");

        //normally when you create a new obj in polymorphism you use new keyword like the following.
//        Mentor mentor = new FullTimeMentor();
        //but in spring framework we will let the container to handle it and tell container to give us the object in it
        //be careful container.getBean() is gonna return Object, you can either cast it or use a second parameter Mentor.class to return a Mentor object
        Mentor fullMentor = (Mentor) container1.getBean("fullTimeMentor");
//        Mentor fullMentor = container1.getBean("fullTimeMentor", Mentor.class);
        fullMentor.createAccount();

        Mentor partMentor = (Mentor) container1.getBean("partTimeMentor");
        partMentor.createAccount();
        //or
        ((Mentor) container1.getBean("partTimeMentor")).createAccount();

        //WAY2
        ApplicationContext container2 = new ClassPathXmlApplicationContext("config.xml");
        Mentor mentor2 = (Mentor) container2.getBean("fullTimeMentor");
        mentor2.createAccount();
    }
}
