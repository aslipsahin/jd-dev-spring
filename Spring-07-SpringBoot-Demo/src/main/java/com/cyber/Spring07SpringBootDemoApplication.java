package com.cyber;

import com.cyber.interfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring07SpringBootDemoApplication {

	public static void main(String[] args) {

		/*
o	@SpringBootApplication (in Spring07SpringBootDemoApplication class which is runner class) in SpringBoot framework
is used to enable the following annotations in JavaCode Spring framework in the configuration class which I named
CyberAppConfig in my projects:
	@ComponentScan: In spring framework I use this annotation to specify the location of beans packages.
SpringBoot framework scans for other configurations and beans in the same package as the Application class or below.
So it is very important to put Application runner class on the top package which is main/java/com/cyber in my case.
	@Configuration: Which marks the class as a source of bean definitions
	@EnableAutoConfiguration: It tells the framework to add bean based on the dependencies on the classpath automatically
o	@SpringBootApplication annotations default scan package is its own package. If I want to override it I can do
@SpringBootApplication(scanBasePackages=”com.cyber.package_name”). And I can add multiple packages by adding commas
between the package names.
o	I do not have to create a container in SpringBoot framework since SpringApplication.run creates one for me
automatically as in the below script.
		SpringApplication.run(Spring07SpringBootDemoApplication.class, args);
o	Other than this, DI; @Autowired, @Qualifier and @Value annotation usages are the same with JavaCode configuration.

		 */
		ApplicationContext container = SpringApplication.run(Spring07SpringBootDemoApplication.class, args);
		Course course = container.getBean("java", Course.class);
		System.out.println(course.getTeachingHours());
		System.out.println(course.toString());
	}

}
