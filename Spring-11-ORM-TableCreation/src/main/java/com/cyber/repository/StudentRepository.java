package com.cyber.repository;

import com.cyber.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository comes from @Component
@Repository
public interface StudentRepository extends JpaRepository<Car, Long> {

}