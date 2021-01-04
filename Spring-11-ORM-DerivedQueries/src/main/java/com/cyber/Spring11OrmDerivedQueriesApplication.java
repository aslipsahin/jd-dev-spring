package com.cyber;

import com.cyber.repositories.DepartmentRepository;
import com.cyber.repositories.EmployeeRepository;
import com.cyber.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring11OrmDerivedQueriesApplication {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring11OrmDerivedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions() {

        System.out.println("----------Regions start--------------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("United"));
        System.out.println("findTopBy2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("----------Department start--------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision: " + departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Health"));
        System.out.println("findByDivisionEndingWith: " + departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findDistrictTop3ByDivisionContains: " + departmentRepository.findDistrictTop3ByDivisionContains("Hea"));

        System.out.println("----------Employee start--------------");
        System.out.println("findAllByEmail: " + employeeRepository.findAllByEmail("bmanueau0@dion.ne.jp"));

        System.out.println("............................................");
    }

}
