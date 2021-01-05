package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "departments")
@ToString
//    Derived and @Query approaches are good for small to medium apps but for bigger apps, it is better to use Named
//    Queries. Named Queries can be defined by using properties file, annotations in the entity classes or XML file.
//    Than i have to add the method into the related Repository interface which is DepartmentRepository in this case.
@NamedQuery(name = "Department.findAsliDepartment", query = "SELECT d FROM Department d WHERE d.division=?1")
@NamedNativeQuery(name = "Department.countAllDepartments", query = "SELECT * FROM departments", resultClass = Department.class)
//    @NamedQuery--> for JPQL type, @NamedNativeQuery--> for Native SQL type
public class Department {

    @Id
    private String department;
    private String division;

}
