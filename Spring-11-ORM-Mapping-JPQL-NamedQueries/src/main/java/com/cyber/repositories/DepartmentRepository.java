package com.cyber.repositories;

import com.cyber.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentByDivisionIn(List<String> division);

    //    ----------Named Query : i have added the query into jpa-name-queries.properties file-------
    List<Department> retrieveDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String pattern);

//    Named queries through annotation in entity class. After i add the query and annotation into entity class,
//    i have to add the method here as well.
    List<Department> findAsliDepartment(String division);

    List<Department> countAllDepartments();

}
