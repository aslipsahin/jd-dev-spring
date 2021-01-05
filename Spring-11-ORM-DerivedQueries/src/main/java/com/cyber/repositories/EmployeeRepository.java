package com.cyber.repositories;

import com.cyber.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address
    List<Employee> findAllByEmail(String email);

    //Display all employees with first name and last name also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastname, String email);

    //Display all employees whose first name is not '..'
    List<Employee> findByLastNameIsNot(String firstName);

    //Display all employees where last name starts with '...'
    List<Employee> findByLastNameStartingWith(String string);

    //Display all employees with salaries higher than '...'
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than or equal to'...'
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between ',,' and ',,'
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater or equal to ',,' in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ',,'
    List<Employee> findDistinctTop3BySalaryLessThan(Integer Salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailNull();
}
