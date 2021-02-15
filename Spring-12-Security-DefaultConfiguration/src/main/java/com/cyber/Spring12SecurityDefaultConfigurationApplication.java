package com.cyber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring12SecurityDefaultConfigurationApplication {


	/*
	*the following process is form based authentication provided by spring
	org.springframework.security creates a form based authentication automatically. after i created HomeController
	with getMapping index method and run the app, i can see the generated security password in the console like:
				Using generated security password: 4ab0eda4-5c97-4c5d-9903-4bc756da84e9
	then navigate to : http://localhost:8080/login
	 credentials for above link: spring created automatically
	 							the username as "user" and
	 							the password as the generated in the console.

	 *i can override these username and password by adding the following lines into the application.properties

	 *when you go to google and click on the 3dots on the top upper corner and select "new incognito window" (which is
	 a different version of google chrome), a new windows be open. it is better to work security here because it
	 *does not save cookies.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Spring12SecurityDefaultConfigurationApplication.class, args);
	}

}
