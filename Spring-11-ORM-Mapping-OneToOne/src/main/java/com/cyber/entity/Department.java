package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
public class Department extends BaseEntity {

    private String department;
    private String division;

    /*
    For BIDIRECTIONAL relationship
    * The relationship btw the tables can be unidirectional or bidirectional. if i want to have a relationship from both
    Employee to Department and Department to Employee, i should add @OneToOne or other relationship annotation to both pojos.
    * If i use @OneToOne annotation without any params, then both table will include the foreign keys for each other.
    To prevent it, i need to add param 'mappedBy' with the variable name. By this the department table will not have
    the foreign key, and it posts the ownership to Employee table.
    * This is kind of parent-child relationship. Here employees table is the parent, and departments table is the child.
    Meaning Department cannot exist without employee. Whenever i create Employee, Department and Region will be created.
     */
    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }

}