package com.cyber;

import com.cyber.interfaces.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring07SpringBootCarpetCostCalculatorApplication {

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(Spring07SpringBootCarpetCostCalculatorApplication.class, args);
		Room kitchen = container.getBean("kitchen", Room.class);
		kitchen.print();
		Room bedroom = container.getBean("bedroom", Room.class);
		bedroom.print();
		Room livingRoom = container.getBean("livingRoom", Room.class);
		livingRoom.print();
	}

}
