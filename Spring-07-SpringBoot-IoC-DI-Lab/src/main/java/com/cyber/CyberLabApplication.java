package com.cyber;

import com.cyber.calculator.Calculator;
import com.cyber.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CyberLabApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext container = SpringApplication.run(CyberLabApplication.class, args);
		Calculator calculator = container.getBean("calculator", Calculator.class);
		System.out.println(calculator.getTotalCarpetCost(City.ARLINGTON));
	}

}
