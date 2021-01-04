package com.cyber.entity;

import com.cyber.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employees")
@ToString
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    //    i do not need fetch and cascade since everything comes from data.sql
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer salary;

    //    i do not need fetch and cascade since everything comes from data.sql
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
