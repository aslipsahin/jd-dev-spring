package com.cyber.entity;

import com.cyber.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="students")
public class Student {

//    when spring creates the variables in db as columns it takes upper cases with _ like:
//    firstName in pojo will be first_name in db. this is the naming convention
    @Id
//    @GeneratedValue is used to create id automatically. IDENTITY is used for postgres, SEQUENCE is used for oracle...
//        then we do not need to add id as a variable anymore when we create the object.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    Normally i do not need to add @Column annotation. If i do not add it, the column name will be the same with the
    variable name except it will add '_' before upper cases and update upper case as lower case. I can change the
    column name by using @Column annotation.
    Remember to update the column names if i use this annotation. I changed file name to data2.sql to prevent spring
    to search the file.
     */
    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmailAddress")
    private String email;

//  if i do not want to see the column in db i use @Transient annotation. Basically it prevents mapping
//  (meaning it prevents object to be persist)
   @Transient
   private String city;

// before java8 if i want to add Date objects in DB, i want to use @Temporal annotation like below to make the format correct in DB.
   @Temporal(TemporalType.DATE)
   private Date birthDate;
   @Temporal(TemporalType.TIME)
   private Date birthTime;
   @Temporal(TemporalType.TIMESTAMP)
   private Date birthDateTime;

// after java8 if i want to add Date objects in DB, i want to use @Column annotation like below to make the format correct in DB.
   @Column(columnDefinition = "DATE")
   private LocalDate localDate;
   @Column(columnDefinition = "TIME")
   private LocalDateTime localDateTime;
   @Column(columnDefinition = "TIMESTAMP")
   private LocalTime localTime;

// @Enumerated annotaion is used for Enums and add the enumType type into it.
   @Enumerated(EnumType.STRING)
   private Gender gender;

}
