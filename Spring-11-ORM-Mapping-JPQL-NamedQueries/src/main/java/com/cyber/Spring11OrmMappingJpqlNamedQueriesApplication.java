package com.cyber;

import com.cyber.repositories.DepartmentRepository;
import com.cyber.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring11OrmMappingJpqlNamedQueriesApplication {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring11OrmMappingJpqlNamedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testEmployee() {
        System.out.println("----- Employee Repository ------");
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println(employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu"));
        System.out.println(employeeRepository.getEmployeeByEmail("myakovlivf@ucsd.edu"));

        employeeRepository.updateEmployeeJPQL(1);
        employeeRepository.updateEmployeeNativeQuery(1);

//		Named queries through jpa-named-queries.properties file
        System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(2000));
        System.out.println(departmentRepository.retrieveDepartmentByDivision("Home"));

//		Named queries through annotations in entity classes
        System.out.println(departmentRepository.findAsliDepartment("Kids"));
        System.out.println(departmentRepository.countAllDepartments());
    }
}
