package com.cyber;

import com.cyber.entity.Car;
import com.cyber.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrmconfigApplication {

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmconfigApplication.class, args);
    }

    //	@PostConstruct is in method level and it always runs one time and before anything.
    @PostConstruct
    public void dataInit() {
//		in this method i will pum some data into DB
        Car c1 = new Car("BMW", "M5");
        Car c2 = new Car("Kia", "Sorento");
        Car c3 = new Car("Toyota", "Pirius");

		/*
		CarRepository has @Repository annotation meaning it extends Repository interface
		CarRepository interface extends JpaRepository interface
				JpaRepositoryImplementation interface extends JpaRepository interface
		SimpleJpaRepository class implements JpaRepositoryImplementation interface
		SimpleJpaRepository class implements save() method
		SimpleJpaRepository class has @Repository annotation
			CrudRepository interface extends Repository interface
			CrudRepository interface has save() method
		 */
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

        carRepository.delete(c1);


        List<Car> list = new ArrayList<>();
        Car c4 = new Car("BMW", "M5");
        Car c5 = new Car("Kia", "Sorento");
        Car c6 = new Car("Toyota", "Pirius");
        carRepository.saveAll(list);

    }

}
