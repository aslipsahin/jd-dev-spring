package com.cyber.repositories;

import com.cyber.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    //Display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

    //Display all departments in Health Division
    List<Department> findByDivision(String division);

    List<Department> findByDivisionIs(String division);

    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics
    List<Department> findByDivisionEndingWith(String pattern);

    //Display top 3 departments with division name includes 'Hea', without duplicates
    List<Department> findDistrictTop3ByDivisionContains(String pattern);

}
