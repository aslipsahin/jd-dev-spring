package com.cyber.entity;

import javax.persistence.*;


/*Whenever you add @Entity annotation in the class level, relational mapping is done,
the class will be created in the db as a class
@Entity --> Create a table in db with the class name
@Entity & @Table(name="...") --> Create a table with this name for this pojo.
Remember to change the table name in data2.sql if i use this annotation.
@Entity(name="...") --> Create a table with this name for this pojo

Then i need to add the primary_key by using @Id annotaion on the top of the variable
 */
@Entity
@Table(name="cars")
public class Car {

//    the variables will be created as columns in DB. In this case there are 3 columns; id, make, model
//    @Id annotation is used to define the primary key.
    @Id
    private int id;

    private String make;
    private String model;

}
